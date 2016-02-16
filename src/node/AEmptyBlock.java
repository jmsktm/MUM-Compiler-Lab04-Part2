/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AEmptyBlock extends PBlock
{
    private TLBrace _lBrace_;
    private TRBrace _rBrace_;

    public AEmptyBlock()
    {
        // Constructor
    }

    public AEmptyBlock(
        @SuppressWarnings("hiding") TLBrace _lBrace_,
        @SuppressWarnings("hiding") TRBrace _rBrace_)
    {
        // Constructor
        setLBrace(_lBrace_);

        setRBrace(_rBrace_);

    }

    @Override
    public Object clone()
    {
        return new AEmptyBlock(
            cloneNode(this._lBrace_),
            cloneNode(this._rBrace_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyBlock(this);
    }

    public TLBrace getLBrace()
    {
        return this._lBrace_;
    }

    public void setLBrace(TLBrace node)
    {
        if(this._lBrace_ != null)
        {
            this._lBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBrace_ = node;
    }

    public TRBrace getRBrace()
    {
        return this._rBrace_;
    }

    public void setRBrace(TRBrace node)
    {
        if(this._rBrace_ != null)
        {
            this._rBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrace_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBrace_)
            + toString(this._rBrace_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBrace_ == child)
        {
            this._lBrace_ = null;
            return;
        }

        if(this._rBrace_ == child)
        {
            this._rBrace_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBrace_ == oldChild)
        {
            setLBrace((TLBrace) newChild);
            return;
        }

        if(this._rBrace_ == oldChild)
        {
            setRBrace((TRBrace) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
