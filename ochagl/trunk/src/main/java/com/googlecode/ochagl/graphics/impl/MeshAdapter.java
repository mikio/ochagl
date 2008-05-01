package com.googlecode.ochagl.graphics.impl;

import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Material;
import com.googlecode.ochagl.graphics.Mesh;
import com.googlecode.ochagl.graphics.ShadeMode;
import com.googlecode.ochagl.graphics.Texture;
import com.googlecode.ochagl.graphics.Vertex;



/**
 * ���b�V���̋�����N���X�D
 */
public class MeshAdapter implements Mesh {

    /**
     * �R���X�g���N�^
     */
    public MeshAdapter() {
    }

    /**
     * �V�F�[�h���[�h��ݒ肷��D
     *
     * @param mode �V�F�[�h���[�h
     */
    public void setShadeMode(final ShadeMode mode) {
    }

    /**
     * �V�F�[�h���[�h���擾����D
     *
     * @return �V�F�[�h���[�h
     */
    public ShadeMode getShadeMode() {

        return ShadeMode.FLAT;
    }

    /**
     * �����_�����O�X�e�[�g��ݒ肷��D
     *
     * @param state �V�F�[�h���[�h
     */
    public void setState(int state) {
    }

    /**
     * �����_�����O�X�e�[�g��ݒ肷��D
     *
     * @param state �V�F�[�h���[�h
     */
    public void unsetState(int state) {
    }

    /**
     * �����_�����O�X�e�[�g���擾����D
     *
     * @return state �V�F�[�h���[�h
     */
    public int getState() {
        return 0;
    }

    /**
     * �e�N�X�`����ݒ肷��D
     *
     * @param tex �e�N�X�`��
     */
    public void setTexture(final Texture tex) {
    }

    /**
     * �}�e���A����ݒ肷��D
     *
     * @param mat �}�e���A��
     */
    public void setMaterial(final Material mat) {
    }

    /**
     * ���_��ݒ肷��D
     *
     * @param v ���_�I�u�W�F�N�g
     */
    public void setVertex(final Vertex v) {
    }

    /**
     * ���_���擾����D
     *
     * @return ���_�I�u�W�F�N�g
     */
    public Vertex getVertex() {

        return null;
    }

    /**
     * �����_�����O�����s����D
     *
     * @param gcon �`��R���e�L�X�g
     */
    public void render(final GraphicContext gcon) {
    }
}
