/*
 * Created on 2004/11/28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.googlecode.ochagl.graphics;

import java.io.IOException;


/**
 * �e�N�X�`�����[�_�̃C���^�t�F�C�X�B
 *
 */
public interface TextureLoader {

    /**
     * �e�N�X�`����ǂݍ��ށB
     *
     * @param gc �O���t�B�b�N�R���e�L�X�g
     * @param resourceName ���\�[�X��
     *
     * @return �e�N�X�`���I�u�W�F�N�g
     *
     * @throws IOException ���\�[�X��������Ȃ����ɔ����B
     */
    Texture getTexture(
        GraphicContext gc,
        String resourceName) throws IOException;

}
