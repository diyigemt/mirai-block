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



Declaration
Sentence
Variable(name: String, type: KClass, value: Any): Factor
Function(name: String, type: KClass, args: Variable[]?, sentenceBlock: SentenceBlock): Declaration

SentenceBlock(dec: Variable[]?, sentences: Sentence[]?)

Expression(): Sentence
AssignExpression(variable: Variable, expression: Expression): Expression

LogicExpressionA(
argA: LogicExpressionA, argB: LogicExpressionB
): Expression { return argA || argB }

LogicExpressionB(
argA: LogicExpressionB, argB: SimpleExpression
): LogicExpressionA { return argA && argB }

SimpleExpression(
argA: AddOnExpression, argB: AddOnExpression, argC: relationalOperationType
): LogicExpressionB
relationalOperationType: "<=" | ">=" | "<" | ">" | "==" | "!="
AddOnExpression(
argA: AddOnExpression, argB: TermExpression, addOperator: AddOperatorType
): SimpleExpression
AddOperatorType: "+" | "-"
TermExpression(
argA: TermExpression, argB: LogicExpressionC, addOperator: MultiOperatorType
): AddOnExpression
MultiOperatorType: "*"
LogicExpressionC(arg: LogicExpressionC): TermExpression { return !arg }

Factor(): LogicExpressionC
Variable(name: String, type: KClass, value: Any): Factor
FunctionCall(functionName: String, args: Expression[]?): Factor
Number(): Factor

LogicControlSentence(): Sentence
LogicControlIF(arg: Expression[], sentenceBlock: SentenceBlock): LogicControlSentence
LogicControlWhile(arg: Expression[], sentenceBlock: SentenceBlock): LogicControlSentence
LogicControlBreak(): LogicControlSentence
LogicControlReturn(): LogicControlSentence



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
