/*
 * Created on 2005/01/03
 *
 */
package com.googlecode.ochagl.graphics;

/**
 * ���C�g�̃C���^�t�F�C�X.
 */
public interface Light extends Object3d {

    /**
     * ������ݒ肷��D
     *
     * @param r �P�x�i��:0.0�`1.0)
     * @param g �P�x�i��:0.0�`1.0)
     * @param b �P�x�i��:0.0�`1.0)
     */
    void setAmbinet(
        float r,
        float g,
        float b);

    /**
     * ��{�F��ݒ肷��D
     *
     * @param r �P�x�i��:0.0�`1.0)
     * @param g �P�x�i��:0.0�`1.0)
     * @param b �P�x�i��:0.0�`1.0)
     */
    void setDiffuse(
        float r,
        float g,
        float b);

    /**
     * ���ʔ��ˌ���ݒ肷��D
     *
     * @param r �P�x�i��:0.0�`1.0)
     * @param g �P�x�i��:0.0�`1.0)
     * @param b �P�x�i��:0.0�`1.0)
     */
    void setSpecular(
        float r,
        float g,
        float b);

    /**
     * ���U���i����������鐬���j��ݒ肷��D
     *
     * @param r �P�x�i��:0.0�`1.0)
     * @param g �P�x�i��:0.0�`1.0)
     * @param b �P�x�i��:0.0�`1.0)
     */
    void setEmissive(
        float r,
        float g,
        float b);

    /**
     * ���ʔ��ˌ��̉s����ݒ肷��D
     *
     * @param s D���ʔ��ˌ��̉s���i0.0�`1.0�j
     */
    void setShininess(float s);
}
