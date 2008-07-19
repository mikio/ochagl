package com.googlecode.ochagl.core;

import java.util.ArrayList;
import java.util.List;


/**
 * Queue�N���X�B �����O�o�b�t�@�Ŏ�������B
 */
public class Queue {

    /**
     * �����O�o�b�t�@�̃T�C�Y�B
     */
    private static final int SIZE = 256;

    /**
     * ���ɓǂނׂ��o�b�t�@�̈ʒu�B
     */
    private int read_;

    /**
     * ���ɏ����ׂ��o�b�t�@�̈ʒu�B
     */
    private int write_;

    /**
     * �o�b�t�@�R���e�i�B
     */
    private List list_ = null;

    /**
     * �R���X�g���N�^�B
     */
    public Queue() {
        this(SIZE);
    }

    /**
     * �R���X�g���N�^�B
     *
     * @param size �o�b�t�@�T�C�Y
     */
    public Queue(final int size) {

        write_ = 0;
        read_ = 0;
        list_ = new ArrayList();

        for (int i = 0; i < size; i++) {

            list_.add(i, null);
        }
    }

    /**
     * ���̃C���f�b�N�X�𓾂�B
     *
     * @param index �C���f�b�N�X
     *
     * @return ���̃C���f�b�N�X
     */
    private int next(final int index) {

        return (index + 1) % list_.size();
    }

    /**
     * �L���[�ɓ����B
     *
     * @param object �i�[����I�u�W�F�N�g
     *
     * @return ���ꂽ�I�u�W�F�N�g�Bnull�̏ꍇ�͎��s
     */
    public Object enqueue(final Object object) {

        // �o�b�t�@�͂��ׂĎg�p��
        // write_ �|�C���^�� read_ �|�C���^�ɒǂ������Ƃ͂Ȃ�
        if (next(write_) == read_) {

            return null;
        }

        list_.add(write_, object);
        write_ = next(write_);

        return object;
    }

    /**
     * �L���[����o���B
     *
     * @return ���o�����I�u�W�F�N�g�Bnull�̏ꍇ�͎��s
     */
    public Object dequeue() {

        // �����O�o�b�t�@�͋�
        if (read_ == write_) {

            return null;
        }

        Object o = list_.get(read_);
        read_ = next(read_);

        return o;
    }
}
