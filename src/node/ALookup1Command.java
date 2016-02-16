/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ALookup1Command extends PCommand
{
    private TLookup1 _lookup1_;
    private TIdent _ident_;
    private TSemicolon _semicolon_;

    public ALookup1Command()
    {
        // Constructor
    }

    public ALookup1Command(
        @SuppressWarnings("hiding") TLookup1 _lookup1_,
        @SuppressWarnings("hiding") TIdent _ident_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setLookup1(_lookup1_);

        setIdent(_ident_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new ALookup1Command(
            cloneNode(this._lookup1_),
            cloneNode(this._ident_),
            cloneNode(this._semicolon_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALookup1Command(this);
    }

    public TLookup1 getLookup1()
    {
        return this._lookup1_;
    }

    public void setLookup1(TLookup1 node)
    {
        if(this._lookup1_ != null)
        {
            this._lookup1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lookup1_ = node;
    }

    public TIdent getIdent()
    {
        return this._ident_;
    }

    public void setIdent(TIdent node)
    {
        if(this._ident_ != null)
        {
            this._ident_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ident_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lookup1_)
            + toString(this._ident_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lookup1_ == child)
        {
            this._lookup1_ = null;
            return;
        }

        if(this._ident_ == child)
        {
            this._ident_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lookup1_ == oldChild)
        {
            setLookup1((TLookup1) newChild);
            return;
        }

        if(this._ident_ == oldChild)
        {
            setIdent((TIdent) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}