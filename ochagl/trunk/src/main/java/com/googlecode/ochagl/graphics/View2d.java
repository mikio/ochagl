package com.googlecode.ochagl.graphics;

/**
 * �Q�c�p�̃r���[�D
 */
public interface View2d extends View {

    int CLEAR = 0x01;

    /**
     * �`��I�u�W�F�N�g��o�^����
     *
     * @param priority �`��D�揇��
     * @param object �`��Ώۂ̃I�u�W�F�N�g
     */
    void addRenderObject(int priority, Object2d object);

}
