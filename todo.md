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

一个积木的构成
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
