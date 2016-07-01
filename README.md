# CloneObjectByReflect
Clone all Object  ues reflect.

根据一个已有的对象，克隆一个一模一样的出来。
中心思想：获取已有对象的所有字段，根据字段名，拼接获得所有get/set方法，动态调用它们设置“新对象”的所有属性

