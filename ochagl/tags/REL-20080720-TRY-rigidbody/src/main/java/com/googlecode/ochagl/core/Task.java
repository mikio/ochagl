package com.googlecode.ochagl.core;




/**
 * �^�X�N�C���^�[�t�F�C�X
 */
public interface Task {

    /**
     * �^�X�N�̗D�揇�ʂ��擾����B
     *
     * @return �D�揇��
     */
    int getPriority();

    /**
     * �^�X�N�̖��O���擾����B
     *
     * @return �^�X�N���擾
     */
    String getName();

    /**
     * �^�X�N�̐�������������B
     *
     * @return true:�����Ă��� false:����ł���
     */
    boolean isAlive();

    /**
     * �^�X�N�폜 (�I�[�o���C�h) �h������ꍇ�Asuper.Kill()�����s���邱�ƁB
     */
    void kill();

    /**
     * �^�X�N�ꎞ��~
     * 
     * @param true:��~ false:�ĊJ
     */
    void stop(boolean b);

    /**
     * �^�X�N�̒�~��Ԃ���������B
     *
     * @return true:��~ false:�ĊJ
     */
    boolean isStop();

    /**
     * �^�X�N�����{�́B�h���N���X�ŃI�[�o���C�h���邱�ƁB
     */
    void execute();

}
