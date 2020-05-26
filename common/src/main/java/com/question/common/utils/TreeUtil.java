package com.question.common.utils;

import com.question.common.domain.TreeNode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/17 20:47
 */
public class TreeUtil<T extends TreeNode> {

    private List<T> treeList = new ArrayList<T>();

    public TreeUtil(List<T> treeList) {
        this.treeList = treeList;
    }

    //建立树形结构
    public List<T> builTree() throws Exception {
        List<T> tree =new  ArrayList<T>();
        for(T t : getRootNode()) {
            t = buildChilTree(t);
            tree.add(t);
        }
        return tree;
    }

    //递归，建立子树形结构
    private T buildChilTree(T t) throws Exception {
        List<T> chilMenus =new  ArrayList<T>();
        for(T t2 : treeList) {
            Method getParentId = getMethod(t2.getClass(),"getParentId",null);
            Method getId = getMethod(t.getClass(),"getId",null);
            if(String.valueOf(getParentId.invoke(t2)).trim().equals(String.valueOf(getId.invoke(t)).trim())) {
                chilMenus.add(buildChilTree(t2));
            }
        }
        Method setChildren = getMethod(t.getClass(),"setChildren", new Class[]{List.class});
//        Method setChildren = t.getClass().getDeclaredMethod("setChildren",List.class);
        setChildren.invoke(t,chilMenus);
        return t;
    }

    //获取根节点
    private List<T> getRootNode() throws Exception {
        List<T> rootList =new  ArrayList<T>();
        for(T t : treeList) {
            Method getParentId = getMethod(t.getClass(),"getParentId",null);
            if(String.valueOf(getParentId.invoke(t)).trim().equals("-1")) {
                rootList.add(t);
            }
        }
        return rootList;
    }

    // 递归获取父类方法
    public static Method getMethod(Class clazz, String methodName, final Class[] classes) throws Exception {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            try {
                method = clazz.getMethod(methodName, classes);
            } catch (NoSuchMethodException ex) {
                if (clazz.getSuperclass() == null) {
                    return method;
                } else {
                    method = getMethod(clazz.getSuperclass(), methodName, classes);
                }
            }
        }
        return method;
    }
}
