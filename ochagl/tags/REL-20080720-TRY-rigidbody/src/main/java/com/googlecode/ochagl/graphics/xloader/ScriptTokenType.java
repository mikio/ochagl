/*
 * Created on 2005/11/29
 */
package com.googlecode.ochagl.graphics.xloader;

import java.util.HashMap;
import java.util.Map;


/**
 * �g�[�N���̎�ނ�\���N���X�B
 * @author micky
 *
 */
public class ScriptTokenType {

    /** ���̏I�������킷�B */
    public static final int EOS = -1;

    /** ����������킷�B */
    public static final int INT = 256;

    /** ����������킷�B */
	public static final int FLOAT = 257;

    /** �����������킷�B */
	public static final int STRING = 258;

	/** �L�[���[�h�i�\���j������킷�B */
    public static final int KEYWORD = 259;

	/** �V���{��(�\���ȊO)������킷�B */
    public static final int SYMBOL = 260;
    
    /** �\���B */
    private static Map reserved_ = new HashMap();
    static {
        reserved_.put("Frame", "");
        reserved_.put("Mesh", "");
    }

    /**
     * �\���̃`�F�b�N�B
     * 
     * @param symbol
     *            �V���{��
     * @return true: ���� false :�Ȃ�
     */
    public static boolean isReserve(String symbol) {
        return reserved_.containsKey(symbol);
    }

    /**
     * �\���̃g�[�N����ނ��擾
     * 
     * @param symbol
     *            �V���{��
     * @return �g�[�N�����
     */
    public static int getReserveTokenType(String symbol) {
        return ((Integer) reserved_.get(symbol)).intValue();
    }
}
