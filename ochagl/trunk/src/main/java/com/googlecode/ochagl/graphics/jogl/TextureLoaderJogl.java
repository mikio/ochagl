package com.googlecode.ochagl.graphics.jogl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Texture;
import com.googlecode.ochagl.graphics.TextureLoader;
import com.sun.opengl.util.texture.TextureIO;


/**
 * �e�N�X�`�����[�_��OpenGL�����B
 */
public class TextureLoaderJogl implements TextureLoader {

	/**
	 * �e�N�X�`����ێ�����B
	 */
	private Map textures_ = new HashMap();

	/**
	 * �R���X�g���N�^�B
	 */
	public TextureLoaderJogl() {
	}

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
	public Texture getTexture(final GraphicContext gc, final String resourceName)
			throws IOException {

		Texture tex = (TextureJogl) textures_.get(resourceName);

		if (tex != null) {

			return tex;
		}
		ClassLoader classloader = getClass().getClassLoader();
		System.out.println("classLoader(TextureLoaderJogl):"+classloader);
		URL url = getClass().getClassLoader().getResource(resourceName);

		if (url == null) {
			throw new IOException("Cannot find: " + resourceName);
		}

		com.sun.opengl.util.texture.Texture jtex = TextureIO.newTexture(url,
				true, // mipmap
				null);// filesuffix
		tex = new TextureJogl(jtex);
		textures_.put(resourceName, tex);

		return tex;
	}

}
