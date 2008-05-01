package com.googlecode.ochagl.graphics.jogl;

import javax.media.opengl.GL;

import com.sun.opengl.util.texture.Texture;


/**
 * �e�N�X�`���I�u�W�F�N�g��OpenGL�����B
 * todo �䗦�͂ǂ��Ŏg���̂��H
 */
public class TextureJogl implements com.googlecode.ochagl.graphics.Texture {
    private Texture jtex_;
    /**
     * �R���X�g���N�^�B
     *
     * @param target �^�[�Q�b�g�^�C�v
     * @param textureID �e�N�X�`���h�c
     */
    public TextureJogl(Texture texture) 
    {
        jtex_ = texture;
    }

    /**
     * OpenGL�Ƀe�N�X�`�����o�C���h����B
     *
     * @param gl The GL context to bind to
     */
    public void bind(final GL gl) 
    {
        jtex_.enable();
        jtex_.bind();
        gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
    }

    /**
     * �I���W�i���̍������擾����B
     *
     * @return �I���W�i���̍���
     */
    public int getImageHeight() 
    {
        return jtex_.getImageHeight();
    }

    /**
     * �I���W�i���̕����擾����B
     *
     * @return �I���W�i���̕�
     */
    public int getImageWidth()
    {
        return jtex_.getImageWidth();
    }

    /**
     * �e�N�X�`���̍������擾����B
     *
     * @return �e�N�X�`������
     */
    public float getHeight() 
    {
        return jtex_.getHeight();
    }

    /**
     * �e�N�X�`���̕����擾����B
     *
     * @return �e�N�X�`����
     */
    public float getWidth()
    {
        return jtex_.getWidth();
    }

}
