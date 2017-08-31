# cypress

> cypress [ˈsaɪprɪs] 柏树

## Introduce

此工程致力于标准化常用业务模型和收集优秀代码段，供以后参考。


## Content


### 系统基础
1. 系统日志
2. 异常控制

### 权限模型
<p>
    基于shiro设计一个完整的RBAC(Role-Based Access Control)模型。
</p>

1. 用户管理
2. 角色管理
3. 资源管理


### 流程控制
基于activiti引擎开发一套完整的流程控制模型，支持用户自定义流程。

### 任务分发

支持用户自定义任务(如报表导出任务，定时计算任务等)，需要考虑多实例部署时，
同一任务只能由一个实例执行。

### 报表
基于birt框架的报表导出

### license控制
对各个模块使用权限进行控制


### 配置管理
- 用户配置，包括字典等
- 管理员配置


### 用户操作日志


### 系统日志采集分析
    采集warn级别以上的系统日志进行分析，帮助系统管理员了解系统稳定性


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
|       app : html & controller       |
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