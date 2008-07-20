package com.googlecode.ochagl.graphics.jogl;

import javax.media.opengl.GL;


import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.SemiMode;
import com.googlecode.ochagl.graphics.StringSprite;
import com.googlecode.ochagl.math.Mat4;
import com.googlecode.ochagl.math.Rad;
import com.sun.opengl.util.GLUT;

/**
 * �X�v���C�g�������JOGL�ɂ������N���X�D
 */
public class StringSpriteJogl extends Object2dJogl implements StringSprite {

	/**
	 * �t�H���g�T�C�Y�D
	 */
	private static final int FONT_SIZE = 8;

	/**
	 * ������D
	 */
	private String string_ = null;

	/**
	 * �t�H���g��U�e�N�X�`���T�C�Y(�����j
	 */
	private float fusize_ = 0.0f;

	/**
	 * �t�H���g��V�e�N�X�`���T�C�Y(����)
	 */
	private float fvsize_ = 0.0f;

    /**
     * �R���X�g���N�^�D
     * @param name ���̃I�u�W�F�N�g�̖��O
     */
	public StringSpriteJogl() {
		string_ = "";
	}

	/**
	 * �������ݒ肷��D
	 *
	 * @param string ������
	 */
	public void setString(final String string) {
		string_ = string;
	}

	/**
	 * �v���~�e�B�u�̕`��
	 */
	public void render(GraphicContext gcon) {
		GraphicContextJogl gc = (GraphicContextJogl) gcon;
		GL gl = gc.getGL();

		gl.glColor4f(r_, g_, b_, a_);

		switch (getSemiMode()) {

		case SemiMode.SEMI_NONE: // �������Ȃ�
			gl.glDisable(GL.GL_BLEND);
			break;

		case SemiMode.SEMI_NORMAL: // �ʏ�̔�����
			gl.glEnable(GL.GL_BLEND);
			gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
			break;

		case SEMI_ADD: // ���Z������
			gl.glEnable(GL.GL_BLEND);
			gl.glBlendFunc(GL.GL_ONE, GL.GL_ONE);
			break;
		}

		if (texture_ != null) {
			useTexture(gc, gl);
		} else {
			nouseTexture(gc, gl);
		}
	}

	private void useTexture(GraphicContextJogl gc, GL gl) {

		((TextureJogl) texture_).bind(gl);
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);

		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glPushMatrix();
		gl.glLoadMatrixf(gc.matrixToArray(new Mat4()));

		gl.glRotatef(Rad.toDeg(getRadian()), 0, 0, 1);
		gl.glScalef(getScale(), getScale(), getScale());

		for (int i = 0; i < string_.length(); i++) {
			float x = pos_.x;
			float y = pos_.y;
			char c = string_.charAt(i);
			drawChar(gl, x + (FONT_SIZE * i), y, c);
		}

		gl.glPopMatrix();
	}

	private void nouseTexture(GraphicContextJogl gc, GL gl) {
		GLUT glut = gc.getGLUT();
		gl.glPushMatrix();
		float x = pos_.x;
		float y = pos_.y;
        gl.glDisable(GL.GL_TEXTURE_2D);
		gl.glRasterPos2f(x, y);
		//glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_10, string_);
        glut.glutBitmapString(GLUT.BITMAP_8_BY_13, string_);
		gl.glPopMatrix();
	}

	/**
	 * �P�����`�悷��D
	 *
	 * @param gl GL�I�u�W�F�N�g
	 * @param x �\���w���W
	 * @param y �\���w���W
	 * @param c �\������
	 */
	private void drawChar(final GL gl, final float x, final float y,
			final char c) {

		char a = (char) (c - '\u0020');

		float u = FONT_SIZE * (a % 32);
		float v = FONT_SIZE * (a / 32);
		u /= texture_.getImageWidth();
		v /= texture_.getImageHeight();

		// TODO �t�H���g�T�C�Y���ςɂ���B�P
		fusize_ = (float) FONT_SIZE / texture_.getImageWidth();
		fvsize_ = (float) FONT_SIZE / texture_.getImageHeight();

		gl.glBegin(GL.GL_QUADS);
		gl.glTexCoord2f(u, v);
		gl.glVertex2f(x, y);

		gl.glTexCoord2f(u, v + fusize_);
		gl.glVertex2f(x, y + FONT_SIZE);

		gl.glTexCoord2f(u + fusize_, v + fvsize_);
		gl.glVertex2f(x + FONT_SIZE, y + FONT_SIZE);

		gl.glTexCoord2f(u + fusize_, v);
		gl.glVertex2f(x + FONT_SIZE, y);
		gl.glEnd();
	}
}
