package com.googlecode.ochagl.core;



/**
 * �����̃f�[�^�W�����猻�ݎ�������ɊY���f�[�^��Ԃ��N���X�B
 */
public class InterpolateStep extends Interpolate {
    public float calcValue(int bindex, int eindex, float fraction) {
        return value(bindex);
    }
}
