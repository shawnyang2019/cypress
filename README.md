# cypress

> cypress [ˈsaɪprɪs] 柏树

## Introduce

此工程致力于标准化常用管理业务模型。


## Content

### 权限模型
<p>
    基于shiro设计一个完整的RBAC(Role-Based Access Control)模型。
</p>

1. 用户管理
2. 角色管理
3. 资源管理


### 流程控制
基于activiti引擎开发一套完整的流程控制模型，支持用户自定义流程。
https://gitee.com/wyy396731037/springboot-activiti.git

### 任务管理
支持用户自定义任务(如报表导出任务，定时计算任务等)，需要考虑多实例部署时，
同一任务只能由一个实例执行。


### license控制
对各个模块使用权限进行控制


### 配置管理
- 用户配置，包括字典等
- 管理员配置


### 用户操作日志
    用于审计

### 系统状态监控
    采集日志和分析SQL执行来监控系统

### 报表
基于birt/poi框架的报表导出


### 文档管理
包括文档的上传，下载和归档管理,参考
https://gitee.com/shenzhanwang/Spring-solr.git

### Package introduce

```xml
<modules>
    <module>cypress-app</module>
    <module>cypress-rbac</module>
    <module>cypress-workflow</module>
    <module>cypress-job</module>
    <module>cypress-common</module>
</modules>
```
层次结构<br/>
```
---------------------------------------
|       app : html & bootstrap config |
---------------------------------------
|  rbac  |  job  |  workflow  |  ...  |
---------------------------------------
|  common : util, system config file  |
---------------------------------------
```


## Usage

支持jar war启动

## FAQ

1. 用SVN做版本控制时，支持只编辑其中的一个模块。




## Author

[vv](vivid_xiang@163.com)