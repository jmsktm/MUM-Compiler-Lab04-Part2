/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AEqualsEqualityExpr extends PEqualityExpr
{
    private PEqualityExpr _equalityExpr_;
    private TEquals _equals_;
    private PComparisonExpr _comparisonExpr_;

    public AEqualsEqualityExpr()
    {
        // Constructor
    }

    public AEqualsEqualityExpr(
        @SuppressWarnings("hiding") PEqualityExpr _equalityExpr_,
        @SuppressWarnings("hiding") TEquals _equals_,
        @SuppressWarnings("hiding") PComparisonExpr _comparisonExpr_)
    {
        // Constructor
        setEqualityExpr(_equalityExpr_);

        setEquals(_equals_);

        setComparisonExpr(_comparisonExpr_);

    }

    @Override
    public Object clone()
    {
        return new AEqualsEqualityExpr(
            cloneNode(this._equalityExpr_),
            cloneNode(this._equals_),
            cloneNode(this._comparisonExpr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqualsEqualityExpr(this);
    }

    public PEqualityExpr getEqualityExpr()
    {
        return this._equalityExpr_;
    }

    public void setEqualityExpr(PEqualityExpr node)
    {
        if(this._equalityExpr_ != null)
        {
            this._equalityExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equalityExpr_ = node;
    }

    public TEquals getEquals()
    {
        return this._equals_;
    }

    public void setEquals(TEquals node)
    {
        if(this._equals_ != null)
        {
            this._equals_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equals_ = node;
    }

    public PComparisonExpr getComparisonExpr()
    {
        return this._comparisonExpr_;
    }

    public void setComparisonExpr(PComparisonExpr node)
    {
        if(this._comparisonExpr_ != null)
        {
            this._comparisonExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comparisonExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._equalityExpr_)
            + toString(this._equals_)
            + toString(this._comparisonExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._equalityExpr_ == child)
        {
            this._equalityExpr_ = null;
            return;
        }

        if(this._equals_ == child)
        {
            this._equals_ = null;
            return;
        }

        if(this._comparisonExpr_ == child)
        {
            this._comparisonExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._equalityExpr_ == oldChild)
        {
            setEqualityExpr((PEqualityExpr) newChild);
            return;
        }

        if(this._equals_ == oldChild)
        {
            setEquals((TEquals) newChild);
            return;
        }

        if(this._comparisonExpr_ == oldChild)
        {
            setComparisonExpr((PComparisonExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
