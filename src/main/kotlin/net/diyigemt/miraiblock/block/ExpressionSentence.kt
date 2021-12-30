package net.diyigemt.miraiblock.block

open class ExpressionSentence: Sentence()

class AssignExpression: ExpressionSentence()

class LogicExpression: ExpressionSentence()

class CallExpression: ExpressionSentence()