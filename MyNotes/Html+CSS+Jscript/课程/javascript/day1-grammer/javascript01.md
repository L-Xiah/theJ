# JavaScript
### JavaScript和Java的区别
- Javascript(JS) 和Java是两个不同的产品，java是由Sun公司推出的面向对象的编程语言，最近被Oracle公司所收购，JS是由Netscope公司开发引入的一种嵌入web页面的解释性（脚本）语言。
- Java面向对象编程语言，在java开始时，都是从类的定义开始（class），JS是基于对象，JavaScript本身提供丰富的对象内容供开发人员使用；
- 运行方式：java语言编写完毕之后，需要通过编译，生成相应的字节码，然后由java虚拟机执行生成的字节码；JS脚本语言，不需要经过编译，是由浏览器直接解释执行相应的脚步code
- 声明变量的方式不同：java语言是强语言类型的编程语言，所有的变量必须经过声明或定义才能使用；javascript是弱类型变量语言，在使用变量之前可以不声明，由浏览器在运行时检查数据类型。

### JS的执行流程
1. 用户从浏览器输入相应的内容或提交需求，浏览器将需求发送
2. 浏览器端发送包含js内容的页面，发送给远程的服务器，服务器端要下载包含js code的页面
3. 返回服务器端发出的响应

### JS的引用方式
- 外部引入（通过将外部引入js 代码的标签 嵌入在head标签内部）`<script type="text/javascript" src="js 代码的路径"></script>`。 优先使用相对（本地）js文件，减少网页加载时间/流量。
- 内部嵌入（在html页面标签中，嵌入相应的js代码），可以放置在head标签内部或body标签内部，数量不做限制，遵循从上到下的解释原则。可以根据不同的功能（函数功能）在划分不同的js代码块。
---

### JS变量的定义
javascript是弱类型变量语言，在使用变量之前可以不声明，如果想要使用某个变量，可以直接通过变量名使用。不能使用数字和特殊符号开头(除了下划线`_`)，也不能使用保留关键字（如var，document等），使用驼峰命名法。<br/>
- 隐式定义：直接给变量赋值
````
syntax： 变量名 = 数值;
eg： value=10;
````
- 显式定义： 通过`var`关键字来声明或定义变量。声明变量时，该变量可以没有初始值，类型是不确定的如果在定义变量并赋予初始值的情况下，变量的类型是确定的，不过在后续使用过程中类型可以随意变换。
````
var value1 = 'B';
value1 = 100;

var a, b, c;	// 可以在一行语句中定义多个变量，中间使用","(逗号)分割开；
var a = 1, b = 2, c = 3;  // 声明三个变量的同时，进行赋值操作

函数内 {
  var a = 1; // 在某个函数段内使用var声明的变量叫做局部变量，只能在函数内部访问（作用域 ），当函数运行完毕后，将会被删除（回收）

  carname="Volvo"; // 把值赋给尚未声明的变量，该变量将被自动作为全局变量声明。
}

````
NOTE3：JavaScript定义变量时区分大小写（case sensitive），因此，变量`abc`和`ABC`是两个不同的变量。<br/>

### JS函数的定义
在JS中，对函数的定义与C/C++, Java等也有不同，基本形式为：
````
function 函数名(变量1, ..., 变量n) {
  ...
  // return 返回值（返回值可以没有，使用return将会直接退出函数）
}

// e.g.
function addOperation(a, b) {
  var sum = a + b;
  return sum;
}
````
> 可以通过<button type="button" onclick="xxx()">调用</button>

### JS的基本运算
- 加法运算`+`：
  - 普通数值类型系统则执行数值的"+"运算，如1+1=2
  - 字符串会将"+"作为字符之间的连接符使用，如a+b=ab
- 减法运算`-`：由于字符串不支持减法运算，系统会将字符串直接转换成数值类型，参与相应的运算
- 乘法运算`*`
- 除法运算`/` 5/2=2
- 求余运算`%` 5%2=1
- 比较运算符
  - `>` `<` `>=` `<=`
  - `==` `!=`
  - `===`  判断对象和值相等
- 逻辑运算符`&&` `||`

### JS数据输出
- `alert()`方法直接通过浏览器弹窗
- `document.write()`方法写入到HTML中
- `xxx.innerHTML`方式写到HTML的具体某个节点中
- `console.log()`写入到浏览器的控制台

### JS数据类型
原始类型：
- 数值类型number：包含整数和浮点型数据
  - 普通数据类型 1, 1.0, 1E3, 1.23e-3
  - 特殊数据类型 infinity, NaN(非数字值)
- 字符串类型string：单引号或双引号括起来的"abc" 'abc'
- 布尔类型boolean：true false
- null类型：某个变量为空
- undefined类型：某个创建但未赋值（没有初始值）的变量
对象类型: <i>object</i> - 所有类型都是object，如Array, Date，甚至包括function

### JS内置对象
JS对象：
- `Number` 原始数字类型的包装类
- `String` 字符串类型的包装类
- `Boolean` 布尔类型的包装类
- `Array` 数组类型
- `Math` 基本数学运算的包装类
- `Date` 日期时间及相关操作的包装类
- `RegExp` 正则表达式匹配和处理的包装类
- `Events` JS事件句柄
- `Functions` 函数类型包装类

其他：
- `window`对象：表示浏览器打开的窗口
- `screen`对象：属于`window`，包含客户端显示器的信息
- `history`对象：属于`window`，保存了用户浏览的记录
- `document`对象(DOM)：每个载入浏览器的HTML对象

`this`对象：当前作用自身的原型实例<br/>

创建JS对象：
- 使用`var a = new 类型()`进行创建
- 使用`var a = new Object()`或`var a = {}`创建一个空对象，并使用`.`进行赋值和声明
````
// new Object
var student = new Object();
student.id = 1;
student.name = "马云";
student.math = 85.5;
student.chinese = 75;
student.avgScore = function() {
  return (this.math + this.chinese) / 2;
}

// {}
var student = {
  id: 1,
  name: "马云",
  math: 85.5,
  chinese: 75,
  avgScore: function() {
    return (this.math + this.chinese) / 2;
  }
};
````

### JS数组
创建办法
- `new Array()`
- `new Array(长度)`
- `new Array(值1, 值2, ..., 值n)`
- `Array()`通过构造函数创建

通过`[n]`来选取数组中的第n项

使用`for in`遍历数组
````
for(item in array) {
  ...
}
````

使用`concat()`拼装数组
````
array1.concat(array2);
````

使用`sort()`对数组排序
````
array.sort();
````

### Date类型
- 通过使用`new Date()`创建Date对象，默认为当前时间
- 通过使用`new Date(时间)`来创建指定时间
- `getDate`, `getMonth`, `getFullYear`, `getDay`, `getHours`, `getMinutes`, `getSeconds`,`getTime`
- `set...`
- 在比较`Date`类型的时候，可以直接通过`>`, `<`, `==`来判断

### Math
- Math本身没有构造函数，无需（也不能）创建它的对象
- `Math.max`, `Math.min`
- `Math.sqrt`, `Math.pow`
- `Math.random` 返回[0.0~1.0)的小数
- 常量`PI`, `SQRT2`

### Number类型
原始数据的包装类型
- `toString`, `toLocaleString`
- `toFixed` 指定小数点位数
- 常量`MAX_VALUE`, `MIN_VALUE`, `NaN`, `POSITIVE_INFINITY`, `NEGATIVE_INFINITY`,

````
// 内置函数
parseInt, parseFloat, parseDouble等
isNaN() // 判断当前是不是“不是数字” NaN=Not a Number
````

### JS类型判断
- `typeof`
- `instanceof`
- `Object.prototype.toString()`

### 条件分支
- `if-else`逻辑控制语句
````
// 单纯if语句
if (表达式) {
  ...
}

// if-else语句
if (表达式) {
  ...
} else {
  ...
}

// 多重嵌套语句
if (表达式1) {
  if (表达式3) {
    ...
  }
} else if (表达式2) {
  ...
}
````

- `switch-case`逻辑控制语句
````
switch (表达式) {
  case 选项1:
    ...
    break; // 可选
  ...
  case 选项n:
    ...
    break;
  default:
    ...
    break;
}
````

### 循环
- `for`循环-执行重复操作
````
for(初始化操作; 循环条件; 每次执行) {
  ...
}
````
- `while`循环和`do-while`循环
````
while(循环条件) {
  ...
}

do {

} while(循环条件);

// 区别就是do-while会先执行一次
````
- `break`和`continue`，`break`指跳出循环，而`continue`指执行循环

### try-catch 异常捕获语句
````
try {
  ...
} catch(e) {
  ...
}
````
