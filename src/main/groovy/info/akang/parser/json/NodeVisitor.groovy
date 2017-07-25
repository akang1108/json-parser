package info.akang.parser.json

class NodeVisitor extends JsonBaseVisitor<Object> {

    @Override
    Object visitNode(JsonParser.NodeContext ctx) {
        if (ctx.map()) {
            return ctx.map().accept(new MapVisitor())
        }

        if (ctx.array()) {
            return ctx.array().accept(new ArrayVisitor())
        }
   }
}
