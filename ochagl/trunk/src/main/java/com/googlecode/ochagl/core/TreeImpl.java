package com.googlecode.ochagl.core;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * �c���[��\������N���X�B �^�X�N�c���[�⃌���_�����O�c���[�ɗ��p����B
 */
public class TreeImpl implements Tree {

    /**
     * �e�c���[�B
     */
    private Tree parent_ = null;

    /**
     * �Z�c���[�B
     */
    private Tree prev_ = null;

    /**
     * ��c���[�B
     */
    private Tree next_ = null;

    /**
     * �q�c���[�B
     */
    private Tree child_ = null;

    /**
     * �c���[�̖��O�B
     */
    private String name_ = null;

    /**
     * �R���X�g���N�^�B
     */
    public TreeImpl() {
        this(null);
    }

    /**
     * �c���[�̖��O���w�肷��R���X�g���N�^�B
     *
     * @param name �c���[�̖��O
     */
    public TreeImpl(final String name) {

        setName(name);
    }

    /**
     * �e�c���[��ݒ肷��B
     *
     * @param tree �e�c���[
     */
    public void setParent(final Tree tree) {

        parent_ = tree;
    }

    /**
     * �Z�c���[��ݒ肷��B
     *
     * @param tree �Z�c���[
     */
    public void setPrev(final Tree tree) {

        prev_ = tree;
    }

    /**
     * ��c���[��ݒ肷��B
     *
     * @param tree ��c���[
     */
    public void setNext(final Tree tree) {

        next_ = tree;
    }

    /**
     * �q���c���[��ݒ肷��B
     *
     * @param tree �q���c���[
     */
    public void setChild(final Tree tree) {

        child_ = tree;
    }

    /**
     * �e�c���[���擾����B
     *
     * @return �e�c���[
     */
    public Tree getParent() {

        return parent_;
    }

    /**
     * �Z�c���[���擾����B
     *
     * @return �Z�c���[
     */
    public Tree getPrev() {

        return prev_;
    }

    /**
     * ��c���[���擾����B
     *
     * @return ��c���[
     */
    public Tree getNext() {

        return next_;
    }

    /**
     * �q���c���[���擾����B
     *
     * @return �q���c���[
     */
    public Tree getChild() {

        return child_;
    }

    /**
     * �m�[�h�i���g�j���擾����B
     *
     * @param name �擾�������m�[�h��
     *
     * @return �m�[�h
     */
    public Tree getNode(final String name) {
        Tree node = null;
        Iterator it = iterator();

        while (it.hasNext()) {
            Tree t = (Tree) it.next();
            String n = t.getName();

            if ((n != null) && n.equals(name)) {
                node = t;
                break;
            }
        }

        return node;
    }

    /**
     * �m�[�h����ݒ肷��B
     *
     * @param name �m�[�h��
     */
    public void setName(final String name) {

        name_ = name;
    }

    /**
     * �m�[�h�����擾����B
     *
     * @return �m�[�h��
     */
    public String getName() {

        return name_;
    }

    /**
     * �w�肵���c���[�������̎q���Ƃ��ĂԂ牺����B
     *
     * @param tree �Ԃ牺�������q���c���[
     *
     * @see com.googlecode.ochagl.core.Tree#add(com.googlecode.ochagl.core.Tree)
     */
    public void add(final Tree tree) {

        if (tree != null) {

            tree.remove();

            if (getChild() == null) {

                setChild(tree);
                tree.setParent(this);
            } else {

                Tree curr = getChild();

                while (curr != null) {

                    if (curr.getNext() == null) {

                        tree.setPrev(curr);
                        curr.setNext(tree);
                        tree.setParent(this);

                        break;
                    }

                    curr = curr.getNext();
                }
            }
        }
    }

    /**
     * �w�肵���c���[�̎q���Ƃ��ĂԂ牺����B
     *
     * @param tree �Ԃ牺�������e�c���[
     */
    public void addTo(final Tree tree) {

        if (tree != null) {

            tree.add(this);
        }
    }

    /**
     * ������e�c���[����؂藣���B
     */
    public void remove() {

        if (getParent() != null) {

            if (getParent().getChild() == this) {

                // �ŏ��̎q��
                getParent().setChild(this.getNext());

                if (this.getNext() != null) {

                    // ���̌Z�킪����΁A������ŏ��̎q���ɂ���
                    this.getNext().setPrev(null);
                }
            } else {

                // �Q�Ԗڈȍ~�̎q���̏���
                if (this.getNext() != null) {

                    this.getNext().setPrev(this.getPrev());
                }

                if (this.getPrev() != null) {

                    this.getPrev().setNext(this.getNext());
                }
            }

            this.parent_ = null;
        }

        setNext(null);
        setPrev(null);
    }

    /**
     * �q���c���[�̐����擾����B
     *
     * @return �q���c���[�̐�
     */
    public int countChild() {

        int cc = 0;

        if (getChild() != null) {

            Tree curr = getChild();

            while (curr != null) {

                cc++;
                curr = curr.getNext();
            }
        }

        return cc;
    }

    /**
     * �����ȉ��̊K�w�����擾����B
     *
     * @return �K�w��
     */
    public int countHierarchy() {

        int cc = 0;
        Tree curr;

        if (getChild() != null) {

            curr = getChild();

            while (curr != null) {

                cc++; // for myself.
                cc += curr.countHierarchy();
                curr = curr.getNext();
            }
        }

        return cc;
    }

    /**
     * �C�e���[�^���擾����B
     *
     * @return �C�e���[�^����
     */
    public Iterator iterator() {

        return new TreeItarator(this);
    }

    /**
     * �C�e���[�^�̎����Bremove()�̓T�|�[�g���Ȃ��B
     */
    private static class TreeItarator implements Iterator {

        /**
         * �C�e���[�g���̃J�����g�c���[�B
         */
        private Tree curr = null;

        /**
         * �C�e���[�g����ۂ̍ŏ��̃c���[�B
         */
        private Tree top = null;

        /**
         * DOCUMENT ME!
         */
        private Tree nextObject_ = null;

        /**
         * �R���X�g���N�^�B
         *
         * @param node �C�e���[�g����ۂ̐擪�m�[�h
         */
        TreeItarator(final Tree node) {

            curr = node;
            top = node;
            nextObject_ = node;
        }

        /**
         * hasNext��next�̑O�ɕ�����Ăяo����Ă����삵�Ȃ���΂Ȃ�Ȃ��B�v�f��i�߂鏈���͂����ɋL�q����B
         *
         * @return true:�I�u�W�F�N�g���� false:�I�u�W�F�N�g�Ȃ�
         */
        public boolean hasNext() {

            if (nextObject_ != null) {

                return true;
            }

            if (curr.getChild() != null) {

                curr = curr.getChild();
            } else if (curr == top) {

                curr = null;
            } else if (curr.getNext() != null) {

                curr = curr.getNext();
            } else {

                while (true) {

                    curr = curr.getParent();

                    if (curr == null) {

                        break;
                    }

                    if (curr == top) {

                        curr = null;

                        break;
                    }

                    if (curr.getNext() != null) {

                        curr = curr.getNext();

                        break;
                    }
                }
            }

            nextObject_ = curr;

            return nextObject_ != null;
        }

        /**
         * ���[�U��next�����Ăяo���Ȃ��ꍇ�ł����������삵�A�Ō�ɂ�NoSuchElementsException
         * ���X���[���Ȃ��Ă͂Ȃ�Ȃ��B �v�f��i�߂鏈����hasNext�ōs�Ȃ���B
         *
         * @return �c���[�I�u�W�F�N�g
         *
         * @throws NoSuchElementException DOCUMENT ME!
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
         *
         * @throws UnsupportedOperationException DOCUMENT ME!
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
