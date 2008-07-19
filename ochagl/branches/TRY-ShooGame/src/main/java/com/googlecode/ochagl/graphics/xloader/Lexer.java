/*
 * Created on 2005/11/29
 */
package com.googlecode.ochagl.graphics.xloader;

import java.io.Reader;

/**
 * �����͊�N���X�B�^����ꂽ��������g�[�N���ɕ�������B<br> 
 * �g�[�N���Ƃ́A���l�A������A�L�[���[�h�A�V���{�����w���B<br>
 * �������I�ȃ��\�b�h�͑S�ăp�b�P�[�W�v���C�x�[�g�B<br>
 * ����́A�e�X�g���₷�����邽�߁B<br>
 * ���l�̗��R��LexReader�͂��ׂĈ����łƂ�悤�ɂ��A ���\�b�h�̓Ɨ��������߂Ă���B<br>
 */
class Lexer {

	/** ���[�_�B */
	private LexReader reader_;

	/** ���݂̃g�[�N���̎�ށB */
	private int tokenType_;

	/** ���݂̃g�[�N���̒l */
	private String tokenValue_;
	private int tokenIntValue_;
	private float tokenFloatValue_;

	/**
	 * �f�t�H���g�R���X�g���N�^�B
	 */
	Lexer() {
		reader_ = new LexReader();
	}

	/**
	 * �R���X�g���N�^�B
	 */
	public Lexer(Reader reader) {
		this();
		setReader(reader);
	}

	/**
	 * ���[�_��ݒ肷��B
	 */
	public void setReader(Reader reader) {
		reader_.setReader(reader);
	}

	/**
	 * �ǂݍ��݈ʒu�i��j��Ԃ��B1�I���W���B
	 * @return ��
	 */
	public int getCol() {
		return reader_.getCol();
	}

	/**
	 * �ǂݍ��݈ʒu�i�s�j��Ԃ��B1�I���W���B
	 * @return �s
	 */
	public int getRow() {
		return reader_.getRow();
	}

	/**
	 * �J��Ԃ��\�ȏ�����
	 */
	public void reset() {
		reader_.reset();
	}

	/**
	 * ���݂̃g�[�N������ނ�Ԃ��B
	 * 
	 * @return �g�[�N���̎��
	 */
	public int getTokenType() {
		return tokenType_;
	}

	/**
	 * ���݂̃g�[�N���̒l���擾����B
	 * 
	 * @return ���݂̃g�[�N���̒l
	 */
	public String getValue() {
		return tokenValue_;
	}

	/**
	 * ���݂̃g�[�N���̒l���擾����B
	 * 
	 * @return ���݂̃g�[�N���̒l
	 */
	public int getInt() {
		return tokenIntValue_;
	}

	/**
	 * ���݂̃g�[�N���̒l���擾����B
	 * 
	 * @return ���݂̃g�[�N���̒l
	 */
	public float getFloat() {
		return tokenFloatValue_;
	}

	/**
	 * �g�[�N�������o���A���̃g�[�N���ɐi�ށB
	 * 
	 * @return true:�g�[�N�����o������ false:�g�[�N�����o�����s
	 */
	public boolean advance() {
		return advance(reader_);
	}

	/**
	 * �g�[�N�������o���A���̃g�[�N���ɐi�ށi�������j�B
	 * 
	 * @param reader ���[�_
	 * @return true:�g�[�N�����o������ false:�g�[�N�����o�����s
	 */
	boolean advance(LexReader reader) {
		skipWhitespace(reader);
		int c = reader.read();
		if (c < 0) {
			return false;
		}

		if (isDelimiter(c)) {
			tokenType_ = c;
			return true;
		}

		//System.out.println("c:" + (char)c);
		if (c == '/') {
			tokenType_ = c;
			c = reader.read();
			if (c == '/') {
				skipLineComment(reader);
				return advance();
			} else if (c == '*') {
				skipComment(reader);
				return advance();
			}
			reader.unread();
			return true;
		}

		if (c == '-' || Character.isDigit((char) c)) {
			if (c == '-') {
				skipWhitespace(reader);
			} else {
				reader.unread();
			}
			lexDigit(reader);
			return true;
		}

		reader.unread();
		lexSymbol(reader);
		if (ScriptTokenType.isReserve(tokenValue_)) {
			// �\���
			tokenType_ = ScriptTokenType.KEYWORD;
		}
		return true;
	}

	/**
	 * �󔒂�ǂݔ�΂��B
	 * @param reader ���[�_
	 */
	void skipWhitespace(LexReader reader) {
		int c = reader.read();
		while ((c != -1) && Character.isWhitespace((char) c)) {
			c = reader.read();
		}
		reader.unread();
	}

	/**
	 * �R�����g��ǂݔ�΂��B
	 * @param reader ���[�_
	 */
	void skipLineComment(LexReader reader) {
		int c = 0;
		while ((c = reader.read()) != '\n') {
			if (c < 0) {
				throw new ScriptException("�R�����g���Ƀt�@�C���̏I�[�ɒB���܂����B");
			}
		}
	}

	/**
	 * �����s�R�����g��ǂݔ�΂��B
	 * @param reader ���[�_
	 */
	void skipComment(LexReader reader) {
		int c = 0;
		while (true) {
			c = reader.read();
			if (c < 0) {
				throw new ScriptException("�R�����g���Ƀt�@�C���̏I�[�ɒB���܂����B");
			}
			if (c == '*') {
				c = reader.read();
				if (c == '/') {
					break;
				}
			}
		}
	}

	/**
	 * ������ǂݍ��ށB
	 * @param reader ���[�_
	 */
	void lexDigit(LexReader reader) {
		StringBuffer buf = new StringBuffer();
		int c = 0;
		while (true) {
			c = reader.read();
			if (c < 0) {
				break;
			}
			if (c != '.' && !Character.isDigit((char) c)) {
				reader.unread();
				break;
			}
			buf.append((char) c);
		}

		String value = buf.toString();
		//System.out.printf("digit-value:%s\n", value);
		try {
			tokenIntValue_ = Integer.parseInt(value);
			tokenType_ = ScriptTokenType.INT;
		} catch (Exception e) {
			try {
				tokenFloatValue_ = Float.parseFloat(value);
				tokenType_ = ScriptTokenType.FLOAT;
			} catch (Exception ex) {
				throw new ScriptException("���l�f�[�^���s���ł��B");
			}
		}
	}

	/**
	 * �������ǂݍ��ށB
	 * @param reader ���[�_�B
	 */
	void lexString(LexReader reader) {
		StringBuffer buf = new StringBuffer();
		while (true) {
			int c = reader.read();
			if (c < 0) {
				throw new ScriptException("�����񒆂Ƀt�@�C���̏I�[�ɒB���܂����B");
			}
			if (c == '"') {
				break;
			} else if (c == '\\') {
				c = reader.read();
				if (c < 0) {
					throw new ScriptException("�����񒆂Ƀt�@�C���̏I�[�ɒB���܂����B");
				}
			}
			buf.append((char) c);
		}
		tokenType_ = ScriptTokenType.STRING;
		tokenValue_ = buf.toString();
	}

	/**
	 * �V���{����ǂݍ��ށB
	 * @param reader ���[�_
	 */
	void lexSymbol(LexReader reader) {
		StringBuffer buf = new StringBuffer();
		int c = 0;
		while (true) {
			c = reader.read();
			if (c < 0) {
				break;
			}
			if (isDelimiter(c)) {
				reader.unread();
				break;
			}
			buf.append((char) c);
		}
		tokenType_ = ScriptTokenType.SYMBOL;
		tokenValue_ = buf.toString();
	}

	boolean isDelimiter(int c) {
		switch ((char) c) {
		case ';':
		case '{':
		case '}':
		case ',':
		case '.':
		case '\n':
		case ' ':
			return true;
		}
		return false;
	}
}