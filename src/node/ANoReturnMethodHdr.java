/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ANoReturnMethodHdr extends PMethodHdr
{
    private TVoid _void_;
    private TIdentifier _identifier_;

    public ANoReturnMethodHdr()
    {
        // Constructor
    }

    public ANoReturnMethodHdr(
        @SuppressWarnings("hiding") TVoid _void_,
        @SuppressWarnings("hiding") TIdentifier _identifier_)
    {
        // Constructor
        setVoid(_void_);

        setIdentifier(_identifier_);

    }

    @Override
    public Object clone()
    {
        return new ANoReturnMethodHdr(
            cloneNode(this._void_),
            cloneNode(this._identifier_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANoReturnMethodHdr(this);
    }

    public TVoid getVoid()
    {
        return this._void_;
    }

    public void setVoid(TVoid node)
    {
        if(this._void_ != null)
        {
            this._void_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._void_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._void_)
            + toString(this._identifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._void_ == child)
        {
            this._void_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._void_ == oldChild)
        {
            setVoid((TVoid) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
