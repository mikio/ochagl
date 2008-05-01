package com.googlecode.ochagl.graphics;

/**
 * �r���[�̃C���^�t�F�C�X.
 */
public interface View {

    /**
     * �N���A�J���[��ݒ肷��.
     *
     * @param r ��
     * @param g ��
     * @param b ��
     */
    void setClearColor(
        float r,
        float g,
        float b);

    /**
     * View�X�e�[�g�̐ݒ�
     * @param state �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    void setState(int state);

    /**
     * View�X�e�[�g�̂��O��
     * @param state �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    void unsetState(int state);

    /**
     * �����_�����O���̃Z�b�g�A�b�v.
     *
     * @param gcon �`��R���e�L�X�g
     */
    void begin(GraphicContext gcon);

    /**
     * �����_�����O�̌�n��.
     *
     * @param gcon �`��R���e�L�X�g
     */
    void end(GraphicContext gcon);

    /**
     * �����_�����O �������Ȃ�.
     *
     * @param gcon �`��R���e�L�X�g
     */
    void render(GraphicContext gcon);

    /**
     * �I�u�W�F�N�g��`��c���[����폜
     *
     */
    void remove();

    /**
     * �\���E��\��.
     *
     * @param b true�F�\�� false�F��\��
     */
    void show(boolean b);

    /**
     * �\���`�F�b�N.
     *
     * @return true�F�\�� false�F��\��
     */
    boolean isShow();
}
