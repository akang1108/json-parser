package info.akang.parser.json

class ArrayVisitor extends JsonBaseVisitor<List> {

    @Override
    List visitArray(JsonParser.ArrayContext ctx) {
        ctx.nodeOrValue().collect { nodeOrValue ->
            if (nodeOrValue.val() != null) {
                return nodeOrValue.val().accept(new ValVisitor())
            } else {
                return nodeOrValue.node().accept(new NodeVisitor())
            }
        }
    }
}
