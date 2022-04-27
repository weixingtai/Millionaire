# Millionaire
搭建热门技术框架,实现代码复用，采用官方推荐架构，应用分为界面层+网域层（可选）+数据层，解耦分层，独立开发，各个模块单独集成学习相关技术

一.界面层
1.定义：界面的作用是在屏幕上显示应用数据，并充当主要的用户互动点。每当数据发生变化时，无论是因为用户互动（例如按了某个按钮），还是因为外部输入（例如网络响应），界面都应随之更新，以反映这些变化
2.界面开发语言：Compose
3.应用向用户显示的信息称为界面状态，命名方式：功能 + UiState
4.状态容器：ViewModel
5.状态向下流动、事件向上流动称为单向数据流 (UDF)
6.在 LiveData 或 StateFlow 等可观察数据容器中公开界面状态
7.导航组件：Navigation
8.分页组件：Paging
9.Android动画：Android Motion



二.网域层
1.定义：网域层负责封装复杂的业务逻辑，或者由多个 ViewModel 重复使用的简单业务逻辑。
2.命名：用例以其负责的单一操作命名。具体命名惯例如下：一般现在时动词 + 名词/内容（可选）+ 用例。
3.使用：通过使用 operator 修饰符定义 invoke() 函数，将用例类实例作为函数进行调用。




三.数据层
1.定义：数据层包含应用数据和业务逻辑
2.命名：存储库类以其负责的数据命名：数据类型 + Repository；数据源类以其负责的数据以及使用的来源命名：数据类型 + 来源类型 + DataSource（Remote + Local）
3.本地数据库：Room + DataStore
4.网络请求：Retrofit
5.线程处理：kotlin协程
6.依赖注入：Hilt
7.任务调度：WorkManager
8.网络缓存：Mutex
9.文件存储：File


四.辅助层
1.日志打印：Logger

