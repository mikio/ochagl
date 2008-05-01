package com.googlecode.ochagl.core;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * �\�[�g���ꂽ���X�g��������N���X�B �����D�揇�ʂ����ꍇ�́A�o�^���Ƀ\�[�g�����B List
 * �C���^�t�F�C�X�͎������ׂ����\�b�h����������̂łƂ肠�����ۗ��B
 */
public class SortedList {

    /**
     * ���X�g�̐擪�m�[�h�B
     */
    private Node head_ = null;

    /**
     * ���X�g�̍Ō���m�[�h�B
     */
    private Node tail_ = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public SortedList() {

        head_ = new Node(0, null);
        tail_ = new Node(Integer.MAX_VALUE, null);

        head_.prev_ = null;
        head_.next_ = tail_;
        tail_.prev_ = head_;
        tail_.next_ = null;
    }

    /**
     * �I�u�W�F�N�g�����X�g�ɒǉ�����B
     *
     * @param priority �D�揇��
     * @param object �ǉ�����I�u�W�F�N�g
     */
    public void add(final int priority, final Object object) {

        for (Node n = head_; n != null; n = n.next_) {

            if (priority < n.priority_) {

                Node node = new Node(priority, object);

                node.prev_ = n.prev_;
                node.next_ = n;

                n.prev_.next_ = node;
                n.prev_ = node;

                break;
            }
        }
    }

    /**
     * �m�[�h�����X�g����O���B
     *
     * @param object �O���I�u�W�F�N�g
     */
    public void remove(final Object object) {

        for (Node n = head_; n != null; n = n.next_) {

            if (object == n.object_) {

                n.next_.prev_ = n.prev_;
                n.prev_.next_ = n.next_;

                break;
            }
        }
    }

    /**
     * �C�e���[�^���擾����B
     *
     * @return �C�e���[�^����
     */
    public Iterator iterator() {

        return new SortedListItarator(head_);
    }

    /**
     * ���X�g�̃m�[�h��\���N���X�B
     */
    private static class Node {

        /**
         * �m�[�h�̗D�揇�ʁi���X�g�ɑ}������ۂ̈ʒu�j�B
         */
        private int priority_;

        /**
         * �m�[�h���ێ�����I�u�W�F�N�g�B
         */
        private Object object_;

        /**
         * �O���m�[�h�B
         */
        private Node prev_;

        /**
         * ����m�[�h�B
         */
        private Node next_;

        /**
         * �R���X�g���N�^�B�}���������ʒu���w�肵�A�m�[�h�ɂԂ牺����I�u�W�F�N�g���ݒ肷��B
         *
         * @param priority �}������ʒu
         * @param object �Ԃ牺�������I�u�W�F�N�g
         */
        Node(final int priority, final Object object) {

            priority_ = priority;
            object_ = object;
        }
    }



    /**
     * �C�e���[�^�̎����Bremove()�̓T�|�[�g���Ȃ��B
     */
    private static class SortedListItarator implements Iterator {

        /**
         * �C�e���[�g����ۂ̐擪�m�[�h�B
         */
        private Node node_ = null;

        /**
         * �C�e���[�g�̍ۂ̃J�����g�̃I�u�W�F�N�g�B
         */
        private Object nextObject_ = null;

        /**
         * �R���X�g���N�^�B
         *
         * @param node �C�e���[�g����ۂ̐擪�m�[�h
         */
        SortedListItarator(final Node node) {

            node_ = node;
        }

        /**
         * hasNext��next�̑O�ɕ�����Ăяo����Ă����삵�Ȃ���΂Ȃ�Ȃ��B �v�f��i�߂鏈���͂����ɋL�q����B
         *
         * @return true:�I�u�W�F�N�g���� false:�I�u�W�F�N�g�Ȃ�
         */
        public boolean hasNext() {

            if (nextObject_ != null) {

                return true;
            }

            node_ = node_.next_;
            nextObject_ = node_.object_;

            return nextObject_ != null;
        }

        /**
         * ���[�U��next�����Ăяo���Ȃ��ꍇ�ł� ���������삵�A�Ō�ɂ�NoSuchElementsException
         * ���X���[���Ȃ��Ă͂Ȃ�Ȃ��B �v�f��i�߂鏈����hasNext�ōs�Ȃ���B
         *
         * @return �R���e�i�Ɋi�[�����I�u�W�F�N�g
         */
        public Object next() {

            if ((nextObject_ == null) && !hasNext()) {

                throw new NoSuchElementException();
            }

            Object o = nextObject_;
            nextObject_ = null;

            return o;
        }

        /**
         * �������T�|�[�g���Ȃ��B
         */
        public void remove() {

            throw new UnsupportedOperationException();
        }
    }
}
