package com.googlecode.ochagl.graphics;

import com.googlecode.ochagl.core.Tree;


/**
 * ��ʏ�̑S�Ă̕`��I�u�W�F�N�g��\���C���^�t�F�C�X.
 *
 */
public interface Drawable extends Tree {

    /**
     * �\���w�肷��.
     *
     * @param b true:�\�� false:��\��
     */
    void show(boolean b);

    /**
     * �\������Ă��邩��������.
     *
     * @return true:�\�� false:��\��
     */
    boolean isShow();

    /**
     * �`��c���[�ɐڑ�����Ă��邩��������.
     *
     * @return true:�ڑ�����Ă��� false:�ڑ�����Ă��Ȃ�
     */
    boolean isAlive();

    /**
     * �`��c���[����O��.
     */
    void kill();

    /**
     * �����_�����O����
     *
     * @param gc �`��R���e�L�X�g
     */
    void render(GraphicContext gc);
}
