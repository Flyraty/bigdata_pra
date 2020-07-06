## HomeWork 1
### 简介
存在三个纯数字内容的文件，类似下面这种的，编写 MR 程序读取三个文件进行排序，输出结果文件为 rank排名 + 制表符 + 文件原始内容

```txt
1
4
3
6878
5422
324
```

### 思路
MR shuffle 阶段一定会排序，map 阶段分区局部有序，reduce阶段归并全局有序

### 使用方法
- 打包，使用 spring-boot-maven-plugin 插件指定 main_class 直接打包 exec 可执行jar，运行 jar 包不用额外指定 main class

```sh
mvn clean package
```
- 执行，首先要启动集群，如果想执行本地文件，文件路径需要加上 file:// 用于指定本地文件系统

```
  hadoop jar target/homework-sort-file.jar com.lagou.homework1.SortDriver  ${input_path} ${output_path}
```
