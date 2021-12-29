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
<变量声明> -> <类型说明符> ID;
ID -> \w+
<类型说明符> -> "int" | "void" | "float"
BuildingBlock {
    name: String
    version: String?
    dependent: String[]?
    author: String[]?
    description: String[]?
    listener: Listener[]
}
Listener {
    EventType: KClass
    action: Block[]
}
Block {
    
}
SentenceBlock {
    
}
FunctionBlock {
    
}
