control
if else switch while for break continue

variables
new set get

operator
== != < > <= >= is and or 

bot
reply send

消息构造器


message
text voice image at

event
emit listen

<积木> -> <声明列表>
<声明列表> -> <声明列表> <声明> | <声明>
<声明> -> <变量声明> | <监听器声明> | <函数声明>
<监听器声明> -> <语句块声明>


BuildingBlock {
    name: String
    version: String?
    dependent: String[]?
    author: String[]?
    description: String[]?
    functions: SelfFunction[]?
    variables: Variable[]?
    listener: Listener[]
}
Listener {
    eventType: KClass
    variables: Variable[]?
    sentences: Sentence[]?
}
Variable {
    type: KClass
    value: T
}
SelfFunction {
    inputs: Expression[]
    outputs: Any? // ?
    sentences: Sentence[]?
}
Expression : Sentence {
    ASSIGN, LOGIC, CALL
}
LogicControl : Sentence {
    type: IF | WHILE | BREAK | CONTINUE
}
Block {
    
}
SentenceBlock {
    
}
FunctionBlock {
    
}
