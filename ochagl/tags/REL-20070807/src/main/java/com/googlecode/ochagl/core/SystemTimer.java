package com.googlecode.ochagl.core;



// TODO �i�m�ƃ~�����g��������ׂ�
public final class SystemTimer {

    /**
     * �R���X�g���N�^�B�����֎~
     */
    private SystemTimer() {

    }

    public static long getTime() {
    	return System.nanoTime() / 1000 / 1000; // �~���b�֕ϊ�
    }
}
