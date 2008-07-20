package com.googlecode.ochagl.graphics;

import java.io.IOException;
import java.util.Iterator;

import com.googlecode.ochagl.core.SortedList;



/**
 * �`�敨�}�l�[�W���[�D��ʏ�̑S�Ă̕`�敨���Ǘ�����D
 */
public final class DrawableManager {

    /**
     * �e�N�X�`�����[�_�B
     */
    private TextureLoader textureLoader_;

	/**
	 * �r���[�̃��X�g�B
	 */
	private SortedList viewList_;

	/**
	 * �f�t�H���g�R���X�g���N�^�D
	 */
	public DrawableManager()
	{
		viewList_ = new SortedList();
        textureLoader_ = ResourceFactory.createTextureLoader();
	}

	/**
	 * �r���[�����X�g�ɒǉ��D
	 *
	 * @param priority �D��
	 * @param view �ǉ�����r���[
	 */
	public void addView(final int priority, final View view)
	{
		viewList_.add(priority, view);
	}

	/**
	 * �r���[�����X�g����폜�D
	 *
	 * @param view �폜����r���[
	 */
	public void removeView(final View view)
	{
		viewList_.remove(view);
	}

	/**
	 * �`�敨��`�悷��D
	 *
	 * @param gcon �`��R���e�L�X�g
	 */
	public void draw(final GraphicContext gc) 
	{
		Iterator it = viewList_.iterator();
		while (it.hasNext()) {
			View view = (View) it.next();
			if (view.isShow()) {
				view.begin(gc);
				view.render(gc);
				view.end(gc);
			}
		}

		// �`��c���[����폜
		it = viewList_.iterator();
		while (it.hasNext()) {
			View view = (View) it.next();
			view.remove();
		}
	}

    /**
     * �e�N�X�`����ǂݍ��ށB
     *
     * @param gc �O���t�B�b�N�R���e�L�X�g
     * @param fileName �t�@�C����
     *
     * @return �e�N�X�`���I�u�W�F�N�g
     */
    public Texture loadTexture(final GraphicContext gc, final String fileName) 
    {
        Texture texture = null;

        try {
            texture = textureLoader_.getTexture(gc, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return texture;
    }
}
