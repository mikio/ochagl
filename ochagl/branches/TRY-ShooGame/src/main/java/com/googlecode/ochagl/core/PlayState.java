package com.googlecode.ochagl.core;

/**
 * CD�v���C���[���̏��(�Đ��A��~�A�ꎞ��~�A�R�}����)�� ����킷�N���X�B
 */
public class PlayState {

    /**
     * �Đ����
     */
    public static final String PLAY = "PLAY";

    /**
     * ��~���
     */
    public static final String STOP = "STOP";

    /**
     * �Đ��T�u���
     */
    public static final String SUB_PLAY = "SUB_PLAY";

    /**
     * �ꎞ��~�T�u���
     */
    public static final String SUB_PAUSE = "SUB_PAUSE";

    /**
     * �X�e�b�v�T�u���
     */
    public static final String SUB_STEP = "SUB_STEP";

    /**
     * ��Ԃ�\��
     */
    private String state_;

    /**
     * �T�u���
     */
    private String subState_;

    /**
     * �f�t�H���g�R���X�g���N�^
     */
    public PlayState() {

        state_ = STOP;
        subState_ = SUB_PLAY;
    }

    /**
     * �Đ�
     */
    public void play() {

        state_ = PLAY;
        subState_ = SUB_PLAY;
    }

    /**
     * ��~
     */
    public void stop() {

        state_ = STOP;
    }

    /**
     * �ꎞ��~
     */
    public void pause() {

        if (state_ == PLAY) {

            if (subState_ == SUB_PLAY) {

                subState_ = SUB_PAUSE;
            } else if (subState_ == SUB_PAUSE) {

                subState_ = SUB_PLAY;
            } else if (subState_ == SUB_STEP) {

                subState_ = SUB_PLAY;
            }
        }
    }

    /**
     * �R�}����
     */
    public void step() {

        state_ = PLAY;
        subState_ = SUB_STEP;
    }

    /**
     * ��Ԃ̎擾
     *
     * @return ���
     */
    public String getState() {

        return state_;
    }

    /**
     * �T�u��Ԃ̎擾
     *
     * @return �T�u���
     */
    public String getSubState() {

        return subState_;
    }
}
