/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AProgram extends PProgram
{
    private PClassDecls _classDecls_;

    public AProgram()
    {
        // Constructor
    }

    public AProgram(
        @SuppressWarnings("hiding") PClassDecls _classDecls_)
    {
        // Constructor
        setClassDecls(_classDecls_);

    }

    @Override
    public Object clone()
    {
        return new AProgram(
            cloneNode(this._classDecls_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAProgram(this);
    }

    public PClassDecls getClassDecls()
    {
        return this._classDecls_;
    }

    public void setClassDecls(PClassDecls node)
    {
        if(this._classDecls_ != null)
        {
            this._classDecls_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classDecls_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._classDecls_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._classDecls_ == child)
        {
            this._classDecls_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._classDecls_ == oldChild)
        {
            setClassDecls((PClassDecls) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
