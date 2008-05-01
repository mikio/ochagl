package com.googlecode.ochagl.core;

import java.util.Iterator;


/**
 * �c���[�\����\������C���^�t�F�C�X�B
 */
public interface Tree {

    /**
     * �e�c���[��ݒ肷��B
     *
     * @param tree �e�c���[
     */
    void setParent(Tree tree);

    /**
     * �Z�c���[��ݒ肷��B
     *
     * @param tree �Z�c���[
     */
    void setPrev(Tree tree);

    /**
     * ��c���[��ݒ肷��B
     *
     * @param tree ��c���[
     */
    void setNext(Tree tree);

    /**
     * �q���c���[��ݒ肷��B
     *
     * @param tree �q���c���[
     */
    void setChild(Tree tree);

    /**
     * �e�c���[���擾����B
     *
     * @return �e�c���[
     */
    Tree getParent();

    /**
     * �Z�c���[���擾����B
     *
     * @return �Z�c���[
     */
    Tree getPrev();

    /**
     * ��c���[���擾����B
     *
     * @return ��c���[
     */
    Tree getNext();

    /**
     * �q���c���[���擾����B
     *
     * @return �q���c���[
     */
    Tree getChild();

    /**
     * �m�[�h�i���g�j���擾����B
     *
     * @param name �擾�������m�[�h��
     *
     * @return �m�[�h
     */
    Tree getNode(String name);

    /**
     * �m�[�h����ݒ肷��B
     *
     * @param name �m�[�h��
     */
    void setName(String name);

    /**
     * �m�[�h�����擾����B
     *
     * @return �m�[�h��
     */
    String getName();

    /**
     * �w�肵���c���[�������̎q���Ƃ��ĂԂ牺����B
     *
     * @param tree �Ԃ牺�������q���c���[
     */
    void add(Tree tree);

    /**
     * �w�肵���c���[�̎q���Ƃ��ĂԂ牺����B
     *
     * @param tree �Ԃ牺�������e�c���[
     */
    void addTo(Tree tree);

    /**
     * ������e�c���[����؂藣���B
     */
    void remove();

    /**
     * �q���c���[�̐����擾����B
     *
     * @return �q���c���[�̐�
     */
    int countChild();

    /**
     * �����ȉ��̊K�w�����擾����B
     *
     * @return �K�w��
     */
    int countHierarchy();

    /**
     * �C�e���[�^���擾����B
     *
     * @return �C�e���[�^����
     */
    Iterator iterator();
}
