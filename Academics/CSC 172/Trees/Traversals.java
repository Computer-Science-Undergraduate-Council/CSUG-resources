
/** @param rt The root of the subtree */
void preorder(BinNode rt)
{
  if (rt == null) return; // Empty subtree
  visit(rt);
  preorder(rt.left());
  preorder(rt.right());
}

