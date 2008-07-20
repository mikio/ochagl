/*
 * Created on 2005/01/03
 */
package com.googlecode.ochagl.graphics;




/**
 * ���b�V���̃C���^�t�F�C�X�D
 */
public interface Mesh {

    static final int CULL_FACE = 0x01;
    static final int LIGHTING = 0x02;

    /**
     * �����_�����O�X�e�[�g��ݒ肷��D
     *
     * @param state �����_�����O�X�e�[�g
     */
    void setState(int state);

    /**
     * �����_�����O�X�e�[�g���O��
     *
     * @param state �����_�����O�X�e�[�g
     */
    void unsetState(int state);

    /**
     * �����_�����O�X�e�[�g���擾����D
     *
     * @return state �����_�����O�X�e�[�g
     */
    int getState();

    /**
     * �V�F�[�h���[�h��ݒ肷��D
     *
     * @param mode �V�F�[�h���[�h
     */
    void setShadeMode(ShadeMode mode);

    /**
     * �V�F�[�h���[�h���擾����D
     *
     * @return �V�F�[�h���[�h
     */
    ShadeMode getShadeMode();

    /**
     * �e�N�X�`����ݒ肷��D
     *
     * @param tex �e�N�X�`��
     */
    void setTexture(Texture tex);

    /**
     * �}�e���A����ݒ肷��D
     *
     * @param mat �}�e���A��
     */
    void setMaterial(Material mat);

    /**
     * ���_��ݒ肷��D
     *
     * @param v ���_�I�u�W�F�N�g
     */
    void setVertex(Vertex v);

    /**
     * ���_���擾����D
     *
     * @return ���_�I�u�W�F�N�g
     */
    Vertex getVertex();

    /**
     * �����_�����O�����s����D
     *
     * @param gcon �`��R���e�L�X�g
     */
    void render(GraphicContext gcon);
}
