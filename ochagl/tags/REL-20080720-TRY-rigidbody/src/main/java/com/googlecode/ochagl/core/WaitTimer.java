package com.googlecode.ochagl.core;

/**
 * �E�G�B�g�p�̃^�C�}�N���X�B
 */
public class WaitTimer {

    /**
     * ����J�n���ԁB
     */
    private long prevTime_ = 0;

    /**
     * �R���X�g���N�^�B
     */
    public WaitTimer() {

    }

    /**
     * �^�C�}������������B
     */
    public void reset() {
    	long t = SystemTimer.getTime();
        prevTime_ = t ;
    }

    /**
     * �o�ߎ��Ԃ��擾����B
     *
     * @return �o�ߎ���
     */
    public long getErapsedTime() {
    	long t = SystemTimer.getTime();

        return t  - prevTime_;
    }
}
