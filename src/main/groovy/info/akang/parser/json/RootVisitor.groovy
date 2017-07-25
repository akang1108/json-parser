package info.akang.parser.json

class RootVisitor extends JsonBaseVisitor<Object> {

    @Override
    Object visitRoot(JsonParser.RootContext ctx) {
        return ctx.node().accept(new NodeVisitor())
    }
}
