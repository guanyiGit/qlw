package com.soholy.dogmanager.utils.user;

import java.util.ArrayList;
import java.util.List;

import com.soholy.dogmanager.entity.TResources;
import com.soholy.dogmanager.pojo.user.Tree;

public class BuildTree {
	// 根据资源获取当前资源下的tree
	public static Tree buildTree(TResources resources) {
		Tree tree = new Tree();
		tree.setResourceId(resources.getResourceId());
		tree.setResourceName(resources.getResourceName());
		tree.setAttributes(resources.getKeyword());
		tree.setPid(resources.getParentId());
		return tree;
	}

	// childTrees子节点列表
	public static List<Tree> getTreeChilds(List<Tree> parentTrees, List<Tree> allTrees) {
			List<Tree> trunktrees = new ArrayList<>();
			for (Tree tree : parentTrees) {
				// 根据父节点id获取所有子节点
				List<Tree> childTrees = new ArrayList<>();
				for (Tree tree2 : allTrees) {
					if (tree2.getPid() == tree.getResourceId()) {
						childTrees.add(tree2);
					}
				}
				Tree trunktree = new Tree();
				trunktree.setResourceId(tree.getResourceId());
				trunktree.setResourceName(tree.getResourceName());
				trunktree.setAttributes(tree.getAttributes());

				tree.setChildren(childTrees);
				if (childTrees.size() > 0) {// 如果该节点还有子节点,继续做查询,直到节点没有子节点,也就是最后一个节点
					trunktree.setChildren(getTreeChilds(childTrees, allTrees));
				}
				trunktree.setPid(tree.getPid());
				trunktrees.add(trunktree);
			}
			return trunktrees;
	}
}
