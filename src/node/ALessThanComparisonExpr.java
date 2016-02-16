/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ALessThanComparisonExpr extends PComparisonExpr
{
    private PArithExpr _plusMinusSrc_;
    private TLessThan _lessThan_;
    private PArithExpr _plusMinusTarget_;

    public ALessThanComparisonExpr()
    {
        // Constructor
    }

    public ALessThanComparisonExpr(
        @SuppressWarnings("hiding") PArithExpr _plusMinusSrc_,
        @SuppressWarnings("hiding") TLessThan _lessThan_,
        @SuppressWarnings("hiding") PArithExpr _plusMinusTarget_)
    {
        // Constructor
        setPlusMinusSrc(_plusMinusSrc_);

        setLessThan(_lessThan_);

        setPlusMinusTarget(_plusMinusTarget_);

    }

    @Override
    public Object clone()
    {
        return new ALessThanComparisonExpr(
            cloneNode(this._plusMinusSrc_),
            cloneNode(this._lessThan_),
            cloneNode(this._plusMinusTarget_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALessThanComparisonExpr(this);
    }

    public PArithExpr getPlusMinusSrc()
    {
        return this._plusMinusSrc_;
    }

    public void setPlusMinusSrc(PArithExpr node)
    {
        if(this._plusMinusSrc_ != null)
        {
            this._plusMinusSrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plusMinusSrc_ = node;
    }

    public TLessThan getLessThan()
    {
        return this._lessThan_;
    }

    public void setLessThan(TLessThan node)
    {
        if(this._lessThan_ != null)
        {
            this._lessThan_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lessThan_ = node;
    }

    public PArithExpr getPlusMinusTarget()
    {
        return this._plusMinusTarget_;
    }

    public void setPlusMinusTarget(PArithExpr node)
    {
        if(this._plusMinusTarget_ != null)
        {
            this._plusMinusTarget_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plusMinusTarget_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._plusMinusSrc_)
            + toString(this._lessThan_)
            + toString(this._plusMinusTarget_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._plusMinusSrc_ == child)
        {
            this._plusMinusSrc_ = null;
            return;
        }

        if(this._lessThan_ == child)
        {
            this._lessThan_ = null;
            return;
        }

        if(this._plusMinusTarget_ == child)
        {
            this._plusMinusTarget_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._plusMinusSrc_ == oldChild)
        {
            setPlusMinusSrc((PArithExpr) newChild);
            return;
        }

        if(this._lessThan_ == oldChild)
        {
            setLessThan((TLessThan) newChild);
            return;
        }

        if(this._plusMinusTarget_ == oldChild)
        {
            setPlusMinusTarget((PArithExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
