/*
 * Created on 2005/01/03
 *
 */
package com.googlecode.ochagl.graphics;



/**
 * �R�c�p�̃r���[�C���^�t�B�C�X.
 */
public interface View3d extends View {

    int CLEAR = 0x01;

    /**
     * ��p���瓧�����e�ϊ��s���ݒ肷��
     *
     * @param fovx �������̉�p
     * @param aspect �c/��
     * @param near �ߕ��ʈʒu
     * @param far �����ʈʒu
     */
    void setPerspective(
        float fovx,
        float aspect,
        float near,
        float far);

    /**
     * ���̃r���[���I�u�W�F�N�g�ɃA�^�b�`����B
     *
     * @param object �����_�����O�ΏۂƂȂ�I�u�W�F�N�g
     */
    void setRenderObject(Object3d object);

    /**
     * �����_�����O�ΏۂƂȂ�I�u�W�F�N�g���擾����
     *
     * @return �����_�����O�ΏۂƂȂ�I�u�W�F�N�g
     */
    Object3d getRenderObject();

    /**
     * �r���[�Ƃ��ĐU�����I�u�W�F�N�g�ݒ肷��B
     *
     * @param object �r���[�Ƃ��ĐU�����I�u�W�F�N�g
     */
    void setViewObject(Object3d object);

    /**
     * �r���[�Ƃ��ĐU�����I�u�W�F�N�g�擾����B
     *
     * @retrun object �r���[�Ƃ��ĐU�����I�u�W�F�N�g
     */
    Object3d getViewObject();
}
