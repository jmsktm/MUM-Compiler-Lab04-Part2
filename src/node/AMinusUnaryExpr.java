/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AMinusUnaryExpr extends PUnaryExpr
{
    private TMinus _minus_;
    private PUnaryExpr _unaryExpr_;

    public AMinusUnaryExpr()
    {
        // Constructor
    }

    public AMinusUnaryExpr(
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") PUnaryExpr _unaryExpr_)
    {
        // Constructor
        setMinus(_minus_);

        setUnaryExpr(_unaryExpr_);

    }

    @Override
    public Object clone()
    {
        return new AMinusUnaryExpr(
            cloneNode(this._minus_),
            cloneNode(this._unaryExpr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusUnaryExpr(this);
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
    }

    public PUnaryExpr getUnaryExpr()
    {
        return this._unaryExpr_;
    }

    public void setUnaryExpr(PUnaryExpr node)
    {
        if(this._unaryExpr_ != null)
        {
            this._unaryExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._unaryExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._minus_)
            + toString(this._unaryExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

        if(this._unaryExpr_ == child)
        {
            this._unaryExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        if(this._unaryExpr_ == oldChild)
        {
            setUnaryExpr((PUnaryExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
