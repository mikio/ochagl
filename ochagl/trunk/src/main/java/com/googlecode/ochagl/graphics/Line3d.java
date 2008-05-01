/*
 * Created on 2005/01/03
 */
package com.googlecode.ochagl.graphics;

/**
 * �R�c���C���̃C���^�t�F�C�X�D
 *
 */
public interface Line3d extends Mesh {

    /**
     * ���C���`��̎n�_�ƏI�_���Ȃ��邩�̐ݒ肷��D
     *
     * @param b true:�Ȃ��� false:�Ȃ��Ȃ�
     */
    void setLoop(boolean b);

    /**
     * �n�_�ƏI�_���Ȃ����Ă��邩��������.
     *
     * @return true:�Ȃ��� false:�Ȃ��Ȃ�
     */
    boolean isLoop();

    /**
     * �P�x�ݒ�D
     *
     * @param r �P�x�i��:0.0�`1.0)
     * @param g �P�x�i��:0.0�`1.0)
     * @param b �P�x�i��:0.0�`1.0)
     */
    void setColor(
        float r,
        float g,
        float b);
}
