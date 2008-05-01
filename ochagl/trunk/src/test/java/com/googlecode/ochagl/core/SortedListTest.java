/*
 * �쐬���F 2004/09/20
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎����Q�ƁB
 * �E�B���h�E �� �ݒ� �� Java �� �R�[�h�E�X�^�C�� �� �R�[�h�E�e���v���[�g
 */
package com.googlecode.ochagl.core;

import java.util.Iterator;

import com.googlecode.ochagl.core.SortedList;

import junit.framework.TestCase;

/**
 * @author ocha
 *
 * 
 * 
 */
public class SortedListTest extends TestCase {

	class TestObject {
		private int i_;
		public TestObject(int i) {
			i_ = i;
		}
		public String toString() {
			return String.valueOf(i_);
		}
	}

    /**
     * 
     */
    public SortedListTest() {
        super();
    }

    /**
     * �ǉ��̃e�X�g
     */
    public void testAdd() {
		StringBuffer sb = new StringBuffer();
		SortedList list = new SortedList();
		list.add(0, new TestObject(0));
		list.add(2, new TestObject(2));
		list.add(4, new TestObject(4));
		list.add(3, new TestObject(3));
		list.add(1, new TestObject(1));
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			TestObject o = (TestObject) it.next();
			sb.append(o.toString());
		}
		assertEquals("01234", sb.toString());
    }

    /**
	 * �폜�̃e�X�g
     */
    public void testRemoveRange() {
        StringBuffer sb = new StringBuffer();
        SortedList list = new SortedList();
        TestObject to = null;
        list.add(0, new TestObject(0));
        list.add(2, new TestObject(2));
        list.add(4, new TestObject(4));
        list.add(3, to = new TestObject(3));
        list.add(1, new TestObject(1));
        list.remove(to);
        
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TestObject o = (TestObject) it.next();
            sb.append(o.toString());
        }
        assertEquals("0124", sb.toString());
    }
}
