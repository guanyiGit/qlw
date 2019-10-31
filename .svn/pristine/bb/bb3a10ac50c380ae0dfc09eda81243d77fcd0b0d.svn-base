//处理树数组的js
function createTreeNode(pre, node, arr) {
    if (node) {
        for (var i = 0; i < arr.length; i++) {//扫描所有的子节点
            if (arr[i].pid == node.nodeid) {
                node.nodes.push(arr[i]);
                arr[i].isChild=true;
            }
        }
    }
    if ((pre + 1) < arr.length){
        createTreeNode(pre + 1, arr[pre + 1], arr);
    }//设置第归边界
    return node;
}
function createTree(arr) {
    createTreeNode(0,arr[0],arr);
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].isChild) {//所有的子节点都存在这个标志
            arr.splice(i,1);
            i--;
        }
    }
    return arr;
}

// function onEmpty(arr) {
//     if (arr.nodes.length>0){
//         for (var i=0;i<arr.nodes.length;i++) {
//             if (arr.nodes[i].nodes.length>0){
//                 for (var a=0;a<arr.nodes[i].nodes.length;a++) {
//                     if (arr.nodes[i].nodes[a].nodes.length>0){
//                         for (var b=0;b<arr.nodes[i].nodes[a].nodes.length;b++) {
//                             if (arr.nodes[i].nodes[a].nodes[b].nodes.length<=0) {
//                                 arr.nodes[i].nodes[a].nodes[b].nodes=null
//                             }
//                         }
//                     } else {
//                         arr.nodes[i].nodes[a].nodes=null
//                     }
//                 }
//             } else {
//                 arr.nodes[i].nodes=null
//             }
//         }
//     }else {
//         arr.nodes=null
//     }
//     return arr
// }





//递归所有子节点，找到所有层级节点
                     function getChildNodeIdArr(node) {
                             var ts = [];
                            if(node.nodes) {
                                     for(x in node.nodes) {
                                             ts.push(node.nodes[x].nodeId);
                                             if(node.nodes[x].nodes) {
                                                     var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);//有第二层，第三层子节点的情况
                                                     for(j in getNodeDieDai) {
                                                             ts.push(getNodeDieDai[j]);
                                                         }
                                                 }
                                         }
                                 } else {
                                    ts.push(node.nodeId);
                                 }
                             return ts;
                         }

                     function setParentNodeCheck(node) {
                             var parentNode = $("#tree").treeview("getNode", node.parentId);
                             if(parentNode.nodes) {
                                     var checkedCount = 0;
                                     for(x in parentNode.nodes) {
                                             if(parentNode.nodes[x].state.checked) {
                                                     checkedCount++;
                                                 } else {
                                                     break;
                                                }
                                         }
                                     if(checkedCount === parentNode.nodes.length) {
                                             $("#treeview").treeview("checkNode", parentNode.nodeId);
                                         setParentNodeCheck(parentNode);
                                         }
                                 }
                         }