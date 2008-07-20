/*
 * Created on 2005/01/03
 */
package com.googlecode.ochagl.graphics;

import java.util.Iterator;

import com.googlecode.ochagl.math.Mat4;
import com.googlecode.ochagl.math.Quat;
import com.googlecode.ochagl.math.Vec3;




/**
 * �R�c�I�u�W�F�N�g�̃C���^�t�F�C�X�D�`��c���[�̃m�[�h�i���W�n�j��\��.
 * <li>�E����W�n</li>
 * <li>�E���]�n</li>
 * <li>�c�����x�N�g��</li>
 * <li>�_�͉E����|����</li>
 */
public interface Object3d extends Drawable {

    /**
     * �ď���������D
     */
    void reset();

    /**
     * ���[���h�}�g���b�N�X���擾����D
     *
     * @return ���[���h�}�g���b�N�X
     */
    Mat4 getWorldMatrix();

    /**
     * ���[�J���}�g���b�N�X���擾����D
     *
     * @return ���[�J���}�g���b�N�X
     */
    Mat4 getLocalMatrix();

    /**
     * ���b�V����ǉ�����D
     *
     * @param mesh ���b�V��
     */
    void addMesh(Mesh mesh);

    /**
     * ���b�V�����폜����D
     *
     * @param mesh ���b�V��
     */
    void removeMesh(Mesh mesh);

    /**
     * ���b�V���̃C�e���[�^���擾����D
     *
     * @return ���b�V���̃C�e���[�^
     */
    Iterator getMeshIterator();

    /**
     * �V�F�[�h���[�h��ݒ肷��D
     *
     * @param mode �V�F�[�h���[�h
     */
    void setShadeMode(ShadeMode mode);

    /**
     * ���[�J���}�g���b�N�X��ݒ肷��D
     *
     * @param m ���[�J���}�g���b�N�X
     */
    void setLocalMatrix(Mat4 m);

    /**
     * �ʒu��ݒ肷��D
     *
     * @param v �ʒu�x�N�g��
     */
    void setPosition(Vec3 v);

    /**
     * �ʒu��ݒ肷��D
     *
     * @param x �w���W
     * @param y �x���W
     * @param z �y���W
     */
    void setPosition(
        float x,
        float y,
        float z);

    /**
     * �ʒu���擾����D
     *
     * @return �ʒu�x�N�g��
     */
    Vec3 getPosition();

    /**
     * DOCUMENT ME!
     *
     * @param matrix DOCUMENT ME!
     */
    void setupTree(Mat4 matrix);

    /**
     * ���[�J���}�g���b�N�X�̂w�������Ɉړ�������D
     *
     * @param val �ړ���
     */
    void moveX(float val);

    /**
     * ���[�J���}�g���b�N�X�̂x�������Ɉړ�������D
     *
     * @param val �ړ���
     */
    void moveY(float val);

    /**
     * ���[�J���}�g���b�N�X�̂y�������Ɉړ�������D
     *
     * @param val �ړ���
     */
    void moveZ(float val);

    /**
     * �}�g���b�N�X���w�肵�������֌�����D
     *
     * @param lat �ڕW�x�N�g��
     */
    void lookat(Vec3 lat);

    /**
     * ���[�J���}�g���b�N�X���w����]������D
     *
     * @param val ��]��
     */
    void rotateX(float val);

    /**
     * ���[�J���}�g���b�N�X���x����]������D
     *
     * @param val ��]��
     */
    void rotateY(float val);

    /**
     * ���[�J���}�g���b�N�X���y����]������D
     *
     * @param val ��]��
     */
    void rotateZ(float val);

    /**
     * ���[�J���}�g���b�N�X��C�ӎ���]������D
     *
     * @param quat DOCUMENT ME!
     */
    void rotateAxis(Quat quat);

    /**
     * ���[���h�}�g���b�N�X�̂w�������̃x�N�g�����擾����D
     *
     * @param out �i�[�p�x�N�g��
     */
    void getVectorX(Vec3 out);

    /**
     * ���[���h�}�g���b�N�X�̂x�������̃x�N�g�����擾����D
     *
     * @param out �i�[�p�x�N�g��
     */
    void getVectorY(Vec3 out);

    /**
     * ���[���h�}�g���b�N�X�̂y�������̃x�N�g�����擾����D
     *
     * @param out �i�[�p�x�N�g��
     */
    void getVectorZ(Vec3 out);

    /**
     * �����_�����O����D
     *
     * @param gcon �`��R���e�L�X�g
     */
    void render(GraphicContext gcon);
}
