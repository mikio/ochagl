/*
 * Created on 2005/11/29
 */
package com.googlecode.ochagl.graphics.xloader;

import java.io.Reader;

/**
 * �ꕶ���߂�@�\�t���̃��[�_�B
 */
class LexReader {

    /** ���[�_�B */
    private Reader reader_ = null;
    
    /** �����R�[�h�B */
    private int ch_ = 0;
    
    /** �J�����ԍ� */
    private int col_;

    /** �s�ԍ� */
    private int row_;

    /**
     *  ������̓ǂݍ��݃t���O�B
     *  true:�ǂ܂Ȃ� false:�ǂ�
     */
    private boolean unread_ = false;

    LexReader(Reader r) {
        reader_ = r;
    }
    
    public LexReader() {
	}
    
    void setReader(Reader r) {
    	reader_ = r;
    }
    
    /**
     * �������ǂݍ��ށB
     * @return �����R�[�h�@
     */
    int read()
    {
        try {
            if (unread_) {
                unread_ = false;
            } else {
                ch_ = reader_.read();
                if ((char)ch_ == '\n') {
                    col_ = 0;
                    row_++;
                } else {
                    col_++;
                }
            }
        } catch (Exception e) {
        	ch_ = -1;
        }
		//System.out.print((char)ch_);
        return ch_;
    }

    /**
     * �ꕶ���߂��B<br>
     * ���ۂɂ́Aread()���\�b�h���Ă΂ꂽ���ɁA1�x����������ǂ܂Ȃ��悤�ɂ���B
     */
    void unread()
    {
        unread_ = true;
    }

    /**
     * �ǂݍ��݈ʒu�i��j��Ԃ��B1�I���W���B
     * @return ��
     */
    public int getCol() {
        return col_ + 1;
    }

    /**
     * �ǂݍ��݈ʒu�i�s�j��Ԃ��B1�I���W���B
     * @return �s
     */
    public int getRow() {
        return row_ + 1;
    }

    /**
     * �J��Ԃ��\�ȏ�����
     */
    public void reset() {
        row_ = 0;
        col_ = 0;
    }
}
