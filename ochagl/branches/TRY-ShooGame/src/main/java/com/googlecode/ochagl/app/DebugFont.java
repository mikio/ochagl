package com.googlecode.ochagl.app;

import com.googlecode.ochagl.graphics.ResourceFactory;
import com.googlecode.ochagl.graphics.SemiMode;
import com.googlecode.ochagl.graphics.StringSprite;
import com.googlecode.ochagl.graphics.Texture;
import com.googlecode.ochagl.graphics.View2d;

public final class DebugFont {

    private static final int FONT_MAX = 256;
    private static final int FONT_SIZE = 8;
    private static StringSprite[] sprites_;
    private static int count_;
    private static int fontsize_;
    private static int x_;
    private static int y_;
    private static int cl_;
    private static View2d view2d_;

    /**
     * �R���X�g���N�^.<br>
     * @param mass ����
     * @param obj ���b�V���I�u�W�F�N�g
     */
    private DebugFont() {}

    /**
     * ������.<br>
     * @param game 
     */
    public static void create(int fontmax) {
    	fontsize_ = FONT_SIZE;
    	count_ = 0;
        x_ = 0;
        y_ = 0;
        cl_ = 0;

        view2d_ = ResourceFactory.createView2d();
        view2d_.show(true);
        // 1000�Ԗڂ̃r���[�Ƃ��ēo�^
        GameBox.drawman().addView(0, view2d_);

        sprites_ = new StringSprite[fontmax];
    	Texture texture = GameBox.loadTexture("font.png");
        for (int i = 0; i < sprites_.length; i++) {
            sprites_[i] = ResourceFactory.createStringSprite();
            sprites_[i].setTexture(texture);
            sprites_[i].setSemiMode(SemiMode.SEMI_NORMAL);
            view2d_.addRenderObject(0, sprites_[i]);
        }
    }

    /**
     * ������
     */
    public static void create() {
    	create(FONT_MAX);
    }

    /**
     * �J��
     */
    public static void destroy() {
    }

    /**
     * ���t���[�����s���鏉����.<br>
     */
    public static void clear() {
    	if (sprites_ == null)
    		return;
    	
    	count_ = 0;
        for (int i = 0; i < sprites_.length; i++) {
            //sprites_[i].kill();
            sprites_[count_].show(false);
        }
    }

    /**
     * �f�o�b�O�\��
     * @param x
     * @param y
     * @param s
     */
    public static void print(int x, int y, String s)
    {
    	if (sprites_ == null)
    		return;
        sprites_[count_].setPosition(x * fontsize_, y * fontsize_);
        sprites_[count_].show(true);
        sprites_[count_].setString(s);
        count_++;
    }

}
