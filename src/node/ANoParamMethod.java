/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ANoParamMethod extends PMethod
{
    private PMethodHdr _methodHdr_;
    private TLPar _lPar_;
    private TRPar _rPar_;
    private PBlock _block_;

    public ANoParamMethod()
    {
        // Constructor
    }

    public ANoParamMethod(
        @SuppressWarnings("hiding") PMethodHdr _methodHdr_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") PBlock _block_)
    {
        // Constructor
        setMethodHdr(_methodHdr_);

        setLPar(_lPar_);

        setRPar(_rPar_);

        setBlock(_block_);

    }

    @Override
    public Object clone()
    {
        return new ANoParamMethod(
            cloneNode(this._methodHdr_),
            cloneNode(this._lPar_),
            cloneNode(this._rPar_),
            cloneNode(this._block_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANoParamMethod(this);
    }

    public PMethodHdr getMethodHdr()
    {
        return this._methodHdr_;
    }

    public void setMethodHdr(PMethodHdr node)
    {
        if(this._methodHdr_ != null)
        {
            this._methodHdr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodHdr_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    public PBlock getBlock()
    {
        return this._block_;
    }

    public void setBlock(PBlock node)
    {
        if(this._block_ != null)
        {
            this._block_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._block_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._methodHdr_)
            + toString(this._lPar_)
            + toString(this._rPar_)
            + toString(this._block_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._methodHdr_ == child)
        {
            this._methodHdr_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._methodHdr_ == oldChild)
        {
            setMethodHdr((PMethodHdr) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}