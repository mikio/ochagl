package com.googlecode.ochagl.core;

import com.googlecode.ochagl.core.PlayState;

import junit.framework.TestCase;

/**
 * �v���C���[(CD�v���C���[�Ȃ�)�̏�ԑJ�ڂ�����킷�N���X
 */
public class PlayStateTest extends TestCase {

	/**
	 * ��~��Ԃ̃e�X�g
	 */
	public void testStopState() {

        PlayState playState = new PlayState();
        assertEquals(PlayState.STOP, playState.getState());

        //////////////////
        // ��~���Đ�
        //////////////////
        playState.play();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // ��~���R�}����
        //////////////////
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());

        playState.step();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_STEP, playState.getSubState());

        //////////////////
        // ��~���ꎞ��~
        //////////////////
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());

        playState.pause();
        assertEquals(PlayState.STOP, playState.getState());

        //////////////////
        // ��~����~
        //////////////////
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());

        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());
    }

    /**
     * �Đ�����Ԃ̃e�X�g
     */
    public void testPlayState() {

        PlayState playState = new PlayState();

        //////////////////
        // �Đ����Đ�
        //////////////////
        playState.play();
        playState.play();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // �Đ����ꎞ��~
        //////////////////
        playState.play();
        playState.pause();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PAUSE, playState.getSubState());

        //////////////////
        // �Đ����R�}����
        //////////////////
        playState.play();
        playState.step();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_STEP, playState.getSubState());

        //////////////////
        // �Đ�����~
        //////////////////
        playState.play();
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());
    }

    /**
     * �ꎞ��~����Ԃ̃e�X�g
     */
    public void testPauseState() {

        PlayState playState = new PlayState();

        //////////////////
        // �ꎞ��~���Đ�
        //////////////////
        playState.pause();
        playState.play();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // �ꎞ��~���ꎞ��~
        //////////////////
        playState.play();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());
        playState.pause();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PAUSE, playState.getSubState());
        playState.pause();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // �ꎞ��~���R�}����
        //////////////////
        playState.pause();
        playState.step();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_STEP, playState.getSubState());

        //////////////////
        // �ꎞ��~����~
        //////////////////
        playState.pause();
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());
    }

    /**
     * �R�}���蒆��Ԃ̃e�X�g
     */
    public void testStepState() {

        PlayState playState = new PlayState();

        //////////////////
        // �R�}���聨�Đ�
        //////////////////
        playState.step();
        playState.play();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // �R�}���聨�ꎞ��~
        //////////////////
        playState.step();
        playState.pause();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_PLAY, playState.getSubState());

        //////////////////
        // �R�}���聨�R�}����
        //////////////////
        playState.step();
        playState.step();
        assertEquals(PlayState.PLAY, playState.getState());
        assertEquals(PlayState.SUB_STEP, playState.getSubState());

        //////////////////
        // �R�}���聨��~
        //////////////////
        playState.step();
        playState.stop();
        assertEquals(PlayState.STOP, playState.getState());
    }
}
